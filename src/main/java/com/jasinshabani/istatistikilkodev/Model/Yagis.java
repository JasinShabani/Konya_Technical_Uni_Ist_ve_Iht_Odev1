package com.jasinshabani.istatistikilkodev.Model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class Yagis {
    @ExcelRow
    private int rowIndex;

    @ExcelCellName("Ay")
    private Integer ay;

    @ExcelCellName("Konya")
    private Double konya;

    @ExcelCellName("İstanbul")
    private Double istanbul;

    @ExcelCellName("Ankara")
    private Double ankara;

    @ExcelCellName("Antalya")
    private Double antalya;

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getAy() {
        return ay;
    }

    public void setAy(Integer ay) {
        this.ay = ay;
    }

    public Double getKonya() {
        return konya;
    }

    public void setKonya(Double konya) {
        this.konya = konya;
    }

    public Double getIstanbul() {
        return istanbul;
    }

    public void setIstanbul(Double istanbul) {
        this.istanbul = istanbul;
    }

    public Double getAnkara() {
        return ankara;
    }

    public void setAnkara(Double ankara) {
        this.ankara = ankara;
    }

    public Double getAntalya() {
        return antalya;
    }

    public void setAntalya(Double antalya) {
        this.antalya = antalya;
    }

    @Override
    public String toString() {
        return "Yagis{" +
                "rowIndex=" + rowIndex +
                ", ay=" + ay +
                ", konya=" + konya +
                ", istanbul=" + istanbul +
                ", ankara=" + ankara +
                ", antalya=" + antalya +
                '}';
    }
}
