package br.com.matriz.controller;

import br.com.matriz.controller.request.MatrizRequest;
import br.com.matriz.controller.response.MatrizResponse;
import br.com.matriz.service.MatrizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Tag(name = "Matriz API")
public class MatrizController {

    final MatrizService service;

    public MatrizController(MatrizService service) {
        this.service = service;
    }

    @Operation(description = "Rotacionar valores de uma matriz quadrada")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description  = "Lista recebida válida",
                    content = {@Content(examples = @ExampleObject(
                            value = "{\n" +
                                    "  \"valido\": true,\n" +
                                    "  \"numeros\": [\n" +
                                    "    3,\n" +
                                    "    1,\n" +
                                    "    4,\n" +
                                    "    2\n" +
                                    "  ]\n" +
                                    "}"
                    ), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description  = "Lista recebida inválida",
                    content = {@Content(examples = @ExampleObject(
                            value = "{\n" +
                                    "  \"valido\": false,\n" +
                                    "  \"numeros\": []\n" +
                                    "}"
                    ), mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PutMapping(path = "matriz", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatrizResponse> rotacionarMatriz(
            @RequestBody
            @Parameter(description = "Lista de inteiros para formar uma matriz quadrada") MatrizRequest request) {
        try {
            return ResponseEntity.ok(service.matriz(request.getNumeros()));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new MatrizResponse(false, new ArrayList<>()));
        }
    }

}
