package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.TipoEjeTransversalDao;
import com.ppt.ppt.models.TipoEjeTransversal;
import com.ppt.ppt.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo_eje")
public class TipoEjeTransversalController {

    @Autowired
    private TipoEjeTransversalDao tipoEjeTransversalDao;

    @RequestMapping(value = "api/tipo_eje", method = RequestMethod.GET)
    public ResponseEntity<List<TipoEjeTransversal>> getTipoEjeTransversal(){ return ResponseEntity.ok(tipoEjeTransversalDao.getTipoEjeTransversal());}

    @RequestMapping(value = "api/tipo_ejebyideje/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TipoEjeTransversal>>  getTipoEjeTransversalByEje(@PathVariable int id){
        if(tipoEjeTransversalDao.getTipoEjeTransversal(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Eje ResponseEntity.ok(transversal no existente"));
        }
        return ResponseEntity.ok(tipoEjeTransversalDao.getTipoEjeTransversalByEje(id));}
}
