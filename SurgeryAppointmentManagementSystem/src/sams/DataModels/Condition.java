/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sams.DataModels;

import java.util.Objects;

/**
 *
 * @author yurireis
 */
public class Condition {
    private String cName;
    private String cDesc;
    private String tLevel;

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCDesc() {
        return cDesc;
    }

    public void setCDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public String getTLevel() {
        return tLevel;
    }

    public void setTLevel(String tLevel) {
        this.tLevel = tLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cName);
        hash = 97 * hash + Objects.hashCode(this.cDesc);
        hash = 97 * hash + Objects.hashCode(this.tLevel);
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
        final Condition other = (Condition) obj;
        if (!Objects.equals(this.cName, other.cName)) {
            return false;
        }
        if (!Objects.equals(this.cDesc, other.cDesc)) {
            return false;
        }
        if (!Objects.equals(this.tLevel, other.tLevel)) {
            return false;
        }
        return true;
    }
    
    
}