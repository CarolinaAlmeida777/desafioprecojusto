package com.precojusto.service;

import com.precojusto.entity.Venda;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class RelatorioService {

    public byte[] gerarRelatorioVendas(List<Venda> vendas) throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Vendas");

        int row = 0;
        for (Venda v : vendas) {
            Row r = sheet.createRow(row++);
            r.createCell(0).setCellValue(v.getId());
            r.createCell(1).setCellValue(v.getCliente().getNome());
            r.createCell(2).setCellValue(v.getValorTotal());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        wb.write(out);
        return out.toByteArray();
    }
}
