package com.jasinshabani.istatistikilkodev.Model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class Trafik {

    @ExcelRow
    private int satirIndex;

    @ExcelCellName("Saat")
    private String saat;

    @ExcelCellName("Kavsak1")
    private Integer kavsak1;

    @ExcelCellName("Kavsak2")
    private Integer kavsak2;

    @ExcelCellName("Kavsak3")
    private Integer kavsak3;


    public int getSatirIndex() {
        return satirIndex;
    }

    public void setSatirIndex(int satirIndex) {
        this.satirIndex = satirIndex;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public Integer getKavsak1() {
        return kavsak1;
    }

    public void setKavsak1(Integer kavsak1) {
        this.kavsak1 = kavsak1;
    }

    public Integer getKavsak2() {
        return kavsak2;
    }

    public void setKavsak2(Integer kavsak2) {
        this.kavsak2 = kavsak2;
    }

    public Integer getKavsak3() {
        return kavsak3;
    }

    public void setKavsak3(Integer kavsak3) {
        this.kavsak3 = kavsak3;
    }

    @Override
    public String toString() {
        return "InvoiceExcel [satirIndex=" + satirIndex + ", saat=" + saat + ", kavsak1=" + kavsak1 + ", kavsak2=" + kavsak2
                + ", kavsak3=" + kavsak3 + "]";
    }

}
