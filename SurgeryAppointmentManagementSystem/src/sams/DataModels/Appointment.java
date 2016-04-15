/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams.DataModels;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author yurireis
 */
public class Appointment {
    private String apName;
    private Date aDate;
    private String aType;

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public Date getADate() {
        return aDate;
    }

    public void setADate(Date aDate) {
        this.aDate = aDate;
    }

    public String getAType() {
        return aType;
    }

    public void setAType(String aType) {
        this.aType = aType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.apName);
        hash = 53 * hash + Objects.hashCode(this.aDate);
        hash = 53 * hash + Objects.hashCode(this.aType);
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
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.apName, other.apName)) {
            return false;
        }
        if (!Objects.equals(this.aDate, other.aDate)) {
            return false;
        }
        if (!Objects.equals(this.aType, other.aType)) {
            return false;
        }
        return true;
    }
    
    
}