package com.example.exercicerecipe.models;

import java.io.Serializable;

public class TotalDaily implements Serializable {
   /* @JsonProperty("ENERC_KCAL")
    public ENERCKCAL eNERC_KCAL;
    @JsonProperty("FAT")
    public FAT fAT;
    @JsonProperty("FASAT")
    public FASAT fASAT;
    @JsonProperty("CHOCDF")
    public CHOCDF cHOCDF;
    @JsonProperty("FIBTG")
    public FIBTG fIBTG;
    @JsonProperty("PROCNT")
    public PROCNT pROCNT;
    @JsonProperty("CHOLE")
    public CHOLE cHOLE;
    @JsonProperty("NA")
    public NA nA;
    @JsonProperty("CA")
    public CA cA;
    @JsonProperty("MG")
    public MG mG;
    @JsonProperty("K")
    public K k;
    @JsonProperty("FE")
    public FE fE;
    @JsonProperty("ZN")
    public ZN zN;
    @JsonProperty("P")
    public P p;
    @JsonProperty("VITA_RAE")
    public VITARAE vITA_RAE;
    @JsonProperty("VITC")
    public VITC vITC;
    @JsonProperty("THIA")
    public THIA tHIA;
    @JsonProperty("RIBF")
    public RIBF rIBF;
    @JsonProperty("NIA")
    public NIA nIA;
    @JsonProperty("VITB6A")
    public VITB6A vITB6A;
    @JsonProperty("FOLDFE")
    public FOLDFE fOLDFE;
    @JsonProperty("VITB12")
    public VITB12 vITB12;
    @JsonProperty("VITD")
    public VITD vITD;
    @JsonProperty("TOCPHA")
    public TOCPHA tOCPHA;
    @JsonProperty("VITK1")
    public VITK1 vITK1;

    public TotalDaily(ENERCKCAL eNERC_KCAL, FAT fAT, FASAT fASAT, CHOCDF cHOCDF, FIBTG fIBTG, PROCNT pROCNT, CHOLE cHOLE, NA nA, CA cA, MG mG, K k, FE fE, ZN zN, P p, VITARAE vITA_RAE, VITC vITC, THIA tHIA, RIBF rIBF, NIA nIA, VITB6A vITB6A, FOLDFE fOLDFE, VITB12 vITB12, VITD vITD, TOCPHA tOCPHA, VITK1 vITK1) {
        this.eNERC_KCAL = eNERC_KCAL;
        this.fAT = fAT;
        this.fASAT = fASAT;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
        this.pROCNT = pROCNT;
        this.cHOLE = cHOLE;
        this.nA = nA;
        this.cA = cA;
        this.mG = mG;
        this.k = k;
        this.fE = fE;
        this.zN = zN;
        this.p = p;
        this.vITA_RAE = vITA_RAE;
        this.vITC = vITC;
        this.tHIA = tHIA;
        this.rIBF = rIBF;
        this.nIA = nIA;
        this.vITB6A = vITB6A;
        this.fOLDFE = fOLDFE;
        this.vITB12 = vITB12;
        this.vITD = vITD;
        this.tOCPHA = tOCPHA;
        this.vITK1 = vITK1;
    }

    public ENERCKCAL geteNERC_KCAL() {
        return eNERC_KCAL;
    }

    public void seteNERC_KCAL(ENERCKCAL eNERC_KCAL) {
        this.eNERC_KCAL = eNERC_KCAL;
    }

    public FAT getfAT() {
        return fAT;
    }

    public void setfAT(FAT fAT) {
        this.fAT = fAT;
    }

    public FASAT getfASAT() {
        return fASAT;
    }

    public void setfASAT(FASAT fASAT) {
        this.fASAT = fASAT;
    }

    public CHOCDF getcHOCDF() {
        return cHOCDF;
    }

    public void setcHOCDF(CHOCDF cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public FIBTG getfIBTG() {
        return fIBTG;
    }

    public void setfIBTG(FIBTG fIBTG) {
        this.fIBTG = fIBTG;
    }

    public PROCNT getpROCNT() {
        return pROCNT;
    }

    public void setpROCNT(PROCNT pROCNT) {
        this.pROCNT = pROCNT;
    }

    public CHOLE getcHOLE() {
        return cHOLE;
    }

    public void setcHOLE(CHOLE cHOLE) {
        this.cHOLE = cHOLE;
    }

    public NA getnA() {
        return nA;
    }

    public void setnA(NA nA) {
        this.nA = nA;
    }

    public CA getcA() {
        return cA;
    }

    public void setcA(CA cA) {
        this.cA = cA;
    }

    public MG getmG() {
        return mG;
    }

    public void setmG(MG mG) {
        this.mG = mG;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public FE getfE() {
        return fE;
    }

    public void setfE(FE fE) {
        this.fE = fE;
    }

    public ZN getzN() {
        return zN;
    }

    public void setzN(ZN zN) {
        this.zN = zN;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VITARAE getvITA_RAE() {
        return vITA_RAE;
    }

    public void setvITA_RAE(VITARAE vITA_RAE) {
        this.vITA_RAE = vITA_RAE;
    }

    public VITC getvITC() {
        return vITC;
    }

    public void setvITC(VITC vITC) {
        this.vITC = vITC;
    }

    public THIA gettHIA() {
        return tHIA;
    }

    public void settHIA(THIA tHIA) {
        this.tHIA = tHIA;
    }

    public RIBF getrIBF() {
        return rIBF;
    }

    public void setrIBF(RIBF rIBF) {
        this.rIBF = rIBF;
    }

    public NIA getnIA() {
        return nIA;
    }

    public void setnIA(NIA nIA) {
        this.nIA = nIA;
    }

    public VITB6A getvITB6A() {
        return vITB6A;
    }

    public void setvITB6A(VITB6A vITB6A) {
        this.vITB6A = vITB6A;
    }

    public FOLDFE getfOLDFE() {
        return fOLDFE;
    }

    public void setfOLDFE(FOLDFE fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    public VITB12 getvITB12() {
        return vITB12;
    }

    public void setvITB12(VITB12 vITB12) {
        this.vITB12 = vITB12;
    }

    public VITD getvITD() {
        return vITD;
    }

    public void setvITD(VITD vITD) {
        this.vITD = vITD;
    }

    public TOCPHA gettOCPHA() {
        return tOCPHA;
    }

    public void settOCPHA(TOCPHA tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    public VITK1 getvITK1() {
        return vITK1;
    }

    public void setvITK1(VITK1 vITK1) {
        this.vITK1 = vITK1;
    }*/
}
