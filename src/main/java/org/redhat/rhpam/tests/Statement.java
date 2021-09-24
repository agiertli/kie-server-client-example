package org.redhat.rhpam.tests;

import java.util.Date;

public class Statement {

    private String bureau;
    private boolean centralSettlement;
    private Date plannedSettlementDate;
    private String accountingType;
    private Date installmentDate;
    private String currency;

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public boolean isCentralSettlement() {
        return centralSettlement;
    }

    public void setCentralSettlement(boolean centralSettlement) {
        this.centralSettlement = centralSettlement;
    }

    public Date getPlannedSettlementDate() {
        return plannedSettlementDate;
    }

    public void setPlannedSettlementDate(Date plannedSettlementDate) {
        this.plannedSettlementDate = plannedSettlementDate;
    }

    public String getAccountingType() {
        return accountingType;
    }

    public void setAccountingType(String accountingType) {
        this.accountingType = accountingType;
    }

    public Date getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Date installmentDate) {
        this.installmentDate = installmentDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
