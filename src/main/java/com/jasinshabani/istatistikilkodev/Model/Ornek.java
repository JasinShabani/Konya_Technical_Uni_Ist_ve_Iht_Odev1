package com.jasinshabani.istatistikilkodev.Model;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
public class Ornek {
    @ExcelRow
    private int rowIndex;

    @ExcelCellName("Name")
    private String name;

    @ExcelCellName("Amount")
    private Double amount;

    @ExcelCellName("Number")
    private String number;

    @ExcelCellName("RecievedDate")
    private String receivedDate;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", name=" + name + ", amount=" + amount + ", number=" + number
                + ", receivedDate=" + receivedDate + "]";
    }

}
