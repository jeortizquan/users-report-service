package com.lighthouse.lib;

import java.util.Date;

public class GebruikerRecord {
    private String voorNaam;
    private String achterNaam;
    private String emailadres;
    private String gewensteTelefoonnummer;
    private long gebruikerId;
    private String typeContract;
    private Date eersteIndienst;
    private Date laatsteUitdienst;
    private boolean indienst;
    private String anoniemeVoornaam;
    private String anoniemeAchternaam;
    private String[] profiel;

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getGewensteTelefoonnummer() {
        return gewensteTelefoonnummer;
    }

    public void setGewensteTelefoonnummer(String gewensteTelefoonnummer) {
        this.gewensteTelefoonnummer = gewensteTelefoonnummer;
    }

    public long getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(long gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public Date getEersteIndienst() {
        return eersteIndienst;
    }

    public void setEersteIndienst(Date eersteIndienst) {
        this.eersteIndienst = eersteIndienst;
    }

    public Date getLaatsteUitdienst() {
        return laatsteUitdienst;
    }

    public void setLaatsteUitdienst(Date laatsteUitdienst) {
        this.laatsteUitdienst = laatsteUitdienst;
    }

    public boolean isIndienst() {
        return indienst;
    }

    public void setIndienst(boolean indienst) {
        this.indienst = indienst;
    }

    public String getAnoniemeVoornaam() {
        return anoniemeVoornaam;
    }

    public void setAnoniemeVoornaam(String anoniemeVoornaam) {
        this.anoniemeVoornaam = anoniemeVoornaam;
    }

    public String getAnoniemeAchternaam() {
        return anoniemeAchternaam;
    }

    public void setAnoniemeAchternaam(String anoniemeAchternaam) {
        this.anoniemeAchternaam = anoniemeAchternaam;
    }

    public String[] getProfiel() {
        return profiel;
    }

    public void setProfiel(String[] profiel) {
        this.profiel = profiel;
    }

    public static final class GebruikerRecordBuilder {
        private String voorNaam;
        private String achterNaam;
        private String emailadres;
        private String gewensteTelefoonnummer;
        private long gebruikerId;
        private String typeContract;
        private Date eersteIndienst;
        private Date laatsteUitdienst;
        private boolean indienst;
        private String anoniemeVoornaam;
        private String anoniemeAchternaam;
        private String[] profiel;

        private GebruikerRecordBuilder() {
        }

        public static GebruikerRecordBuilder aGebruikerRecord() {
            return new GebruikerRecordBuilder();
        }

        public GebruikerRecordBuilder voorNaam(String voorNaam) {
            this.voorNaam = voorNaam;
            return this;
        }

        public GebruikerRecordBuilder achterNaam(String achterNaam) {
            this.achterNaam = achterNaam;
            return this;
        }

        public GebruikerRecordBuilder emailadres(String emailadres) {
            this.emailadres = emailadres;
            return this;
        }

        public GebruikerRecordBuilder gewensteTelefoonnummer(String gewensteTelefoonnummer) {
            this.gewensteTelefoonnummer = gewensteTelefoonnummer;
            return this;
        }

        public GebruikerRecordBuilder gebruikerId(long gebruikerId) {
            this.gebruikerId = gebruikerId;
            return this;
        }

        public GebruikerRecordBuilder typeContract(String typeContract) {
            this.typeContract = typeContract;
            return this;
        }

        public GebruikerRecordBuilder eersteIndienst(Date eersteIndienst) {
            this.eersteIndienst = eersteIndienst;
            return this;
        }

        public GebruikerRecordBuilder laatsteUitdienst(Date laatsteUitdienst) {
            this.laatsteUitdienst = laatsteUitdienst;
            return this;
        }

        public GebruikerRecordBuilder indienst(boolean indienst) {
            this.indienst = indienst;
            return this;
        }

        public GebruikerRecordBuilder anoniemeVoornaam(String anoniemeVoornaam) {
            this.anoniemeVoornaam = anoniemeVoornaam;
            return this;
        }

        public GebruikerRecordBuilder anoniemeAchternaam(String anoniemeAchternaam) {
            this.anoniemeAchternaam = anoniemeAchternaam;
            return this;
        }

        public GebruikerRecordBuilder profiel(String[] profiel) {
            this.profiel = profiel;
            return this;
        }

        public GebruikerRecord build() {
            GebruikerRecord gebruikerRecord = new GebruikerRecord();
            gebruikerRecord.setVoorNaam(voorNaam);
            gebruikerRecord.setAchterNaam(achterNaam);
            gebruikerRecord.setEmailadres(emailadres);
            gebruikerRecord.setGewensteTelefoonnummer(gewensteTelefoonnummer);
            gebruikerRecord.setGebruikerId(gebruikerId);
            gebruikerRecord.setTypeContract(typeContract);
            gebruikerRecord.setEersteIndienst(eersteIndienst);
            gebruikerRecord.setLaatsteUitdienst(laatsteUitdienst);
            gebruikerRecord.setIndienst(indienst);
            gebruikerRecord.setAnoniemeVoornaam(anoniemeVoornaam);
            gebruikerRecord.setAnoniemeAchternaam(anoniemeAchternaam);
            gebruikerRecord.profiel = this.profiel;
            return gebruikerRecord;
        }
    }
}
