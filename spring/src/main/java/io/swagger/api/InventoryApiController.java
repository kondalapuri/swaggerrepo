package io.swagger.api;

import io.swagger.model.InventoryItem;
import io.swagger.model.InventoryItemByLimit;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InventoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addInventory(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody InventoryItem inventoryItem) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<InventoryItemByLimit>> searchInventoryByLimit(@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "inv_limit", required = false) Integer invLimit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<InventoryItemByLimit>>(objectMapper.readValue("[ {  \"releaseDate\" : \"2016-08-29T09:12:33.001Z\",  \"name\" : \"Widget Adapter\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\"}, {  \"releaseDate\" : \"2016-08-29T09:12:33.001Z\",  \"name\" : \"Widget Adapter\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<InventoryItemByLimit>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<InventoryItemByLimit>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
