package com.lighthouse.lib;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenerateUserList {
    public XSSFWorkbook processResponse(String response) throws IOException {

        JSONObject responseJson = new JSONObject(response);
        JSONArray records = responseJson.getJSONArray("records");
        GebruikerRecord[] gebruikerRecords = new GebruikerRecord[records.length()];
        for (int i = 0; i < records.length(); i++) {
            if (records.getJSONObject(i) != null) {
                JSONObject record = records.getJSONObject(i);
                JSONObject faciliteiten = record.getJSONObject("facilities");

                gebruikerRecords[i] = GebruikerRecord.GebruikerRecordBuilder.aGebruikerRecord()
                        .voorNaam(record.getString("firstName"))
                        .achterNaam(record.getString("lastName"))
                        .anoniemeVoornaam(record.getString("anonymFirstName"))
                        .anoniemeAchternaam(record.getString("anonymLastName"))
                        .gebruikerId(record.getLong("userId"))
                        .emailadres(faciliteiten.getString("emailadress"))
                        .eersteIndienst( getJSONDate(record,"serviceDate"))
                        .laatsteUitdienst( getJSONDate(record,"lastServiceDate"))
                        .indienst(record.getBoolean("inService"))
                        .gewensteTelefoonnummer(record.getString("preferedTelefonNumber"))
                        .typeContract(record.getString("typeContract"))
                        .build();

            }

        }
        return writeXlsx(gebruikerRecords);
    }

    private Date getJSONDate(JSONObject jsonObject, String propertyName) {
        try {
            return jsonObject.get(propertyName) == null ? null : new Date(jsonObject.getLong(propertyName));
        } catch (Exception e) {
            return null;
        }
    }
    public XSSFWorkbook writeXlsx(GebruikerRecord[] gebruikerRecords) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("User records");
        Map<String, Object[]> dataContent = new HashMap<>();
        int primaryKey = 1;
        for (GebruikerRecord u : gebruikerRecords) {
            dataContent.put(String.valueOf(primaryKey), new Object[]{primaryKey,
                    u.getGebruikerId(),
                    u.getVoorNaam(),
                    u.getAchterNaam(),
                    u.getEmailadres(),
                    u.getGewensteTelefoonnummer(),
                    u.getEersteIndienst(),
                    u.getLaatsteUitdienst(),
                    u.getTypeContract(),
                    u.isIndienst()});
            primaryKey++;
        }

        Set<String> newRows = dataContent.keySet();
        createHeaderRow(sheet);
        int rownum = sheet.getLastRowNum();
        rownum= rownum == -1?0:1;

        for (String key : newRows) {
            // Creating a new Row in existing XLSX sheet
            Row row = sheet.createRow(rownum++);
            Object[] objArr = dataContent.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof Long) {
                    cell.setCellValue((Long) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Date) {
                    CreationHelper creationHelper = workbook.getCreationHelper();
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/mm/yyyy"));
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }
        return workbook;
    }

    private void createHeaderRow(XSSFSheet sheet) {

        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);

        Cell cell1 = row.createCell(0);
        cell1.setCellStyle(cellStyle);
        cell1.setCellValue("No");

        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cellStyle);
        cell2.setCellValue("Gebruikers Id");

        Cell cell3 = row.createCell(2);
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue("Voornaam");

        Cell cell4 = row.createCell(3);
        cell4.setCellStyle(cellStyle);
        cell4.setCellValue("Achternaam");

        Cell cell5 = row.createCell(4);
        cell5.setCellStyle(cellStyle);
        cell5.setCellValue("Emailadres");

        Cell cell6 = row.createCell(5);
        cell6.setCellStyle(cellStyle);
        cell6.setCellValue("Telefoonnummer");

        Cell cell7 = row.createCell(6);
        cell7.setCellStyle(cellStyle);
        cell7.setCellValue("Eerste Indienst");

        Cell cell8 = row.createCell(7);
        cell8.setCellStyle(cellStyle);
        cell8.setCellValue("Laatste Uitdienst");

        Cell cell9 = row.createCell(8);
        cell9.setCellStyle(cellStyle);
        cell9.setCellValue("Type Contract");

        Cell cell10 = row.createCell(9);
        cell10.setCellStyle(cellStyle);
        cell10.setCellValue("Indienst");
    }
}
