/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams.DataModels;//

import java.util.Objects;

/**
 *
 * @author yurireis
 */
public class Patient {

    private String pName;
    private String pSurname;
    private String pEmail;
    private String pAddress;
    private String pMobPhone;

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPSurname() {
        return pSurname;
    }

    public void setPSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    public String getPEmail() {
        return pEmail;
    }

    public void setPEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getPAddress() {
        return pAddress;
    }

    public void setPAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getPMobPhone() {
        return pMobPhone;
    }

    public void setPMobPhone(String pMobPhone) {
        this.pMobPhone = pMobPhone;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.pName);
        hash = 61 * hash + Objects.hashCode(this.pSurname);
        hash = 61 * hash + Objects.hashCode(this.pEmail);
        hash = 61 * hash + Objects.hashCode(this.pAddress);
        hash = 61 * hash + Objects.hashCode(this.pMobPhone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.pName, other.pName)) {
            return false;
        }
        if (!Objects.equals(this.pSurname, other.pSurname)) {
            return false;
        }
        if (!Objects.equals(this.pEmail, other.pEmail)) {
            return false;
        }
        if (!Objects.equals(this.pAddress, other.pAddress)) {
            return false;
        }
        if (!Objects.equals(this.pMobPhone, other.pMobPhone)) {
            return false;
        }
        return true;
    }
}
