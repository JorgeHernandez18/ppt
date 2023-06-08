package com.ppt.ppt.dto;

import com.ppt.ppt.models.ActividadPA;
import lombok.Data;

import java.util.List;

@Data
public class CrearActividadPA {
    private ActividadPA actividadPA;
    private List<Integer> estudiantes;
}
