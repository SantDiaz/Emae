package com.example.emae.services;

import com.example.emae.model.Branch;
import com.example.emae.model.Variable;
import com.example.emae.repositories.BranchRepository;
import com.example.emae.repositories.VariableRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FormService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private VariableRepository variableRepository;

    public void processExcelFile(InputStream inputStream) throws Exception {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Asumiendo que los datos están en la primera hoja

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yy");
        Row headerRow = sheet.getRow(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Saltar la fila de encabezado

            String branchName = row.getCell(0).getStringCellValue();
            Branch branch = branchRepository.findById(branchName).orElseThrow(() -> new Exception("Branch not found"));

            for (int i = 3; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double value = cell.getNumericCellValue();
                    Date date = dateFormat.parse(headerRow.getCell(i).getStringCellValue());

                    // Guardar los datos en la tabla Variable
                    Variable variable = new Variable();
                    variable.setBranch(branch);
                    variable.setValue((float) value);
                    variable.setDate(date);

                    variableRepository.save(variable);
                }
            }
        }

        workbook.close();
    }
}
