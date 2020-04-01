package com.seriouscompanyname.serverhospital;

import com.google.gson.Gson;
import com.seriouscompanyname.serverhospital.dto.model.StudentDTO;
import com.seriouscompanyname.serverhospital.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class DTOTest {

    private ModelMapper mapper = new ModelMapper();

    @Test
    public void toDTOSimpleStudent() {
        Student student = new Student();
        student.setSurname("A");
        student.setName("B");
        student.setMiddleName("C");
        student.setIllnessDate(LocalDate.now());
        student.setBirthDate(LocalDate.now());
        student.setId(152L);
        StudentDTO dto = mapper.map(student, StudentDTO.class);
        Gson gson = new Gson();
        String beforeConversion = gson.toJson(student);
        //System.out.println(gson.toJson(dto));
        Student afterConversion = gson.fromJson(gson.toJson(dto), Student.class);
        Assert.assertEquals(student, afterConversion);
    }
}
