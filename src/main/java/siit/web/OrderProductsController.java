package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import siit.db.OrderProductDao;

import siit.model.Order;
import siit.model.OrderProduct;
import siit.model.Product;
import siit.service.OrderProductService;
import siit.service.ProductService;

import javax.script.ScriptEngine;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static org.h2.fulltext.FullText.init;


@RestController

public class OrderProductsController {


    @Autowired
    OrderProductService orderProductService;

    //    http://localhost:8080/api/customers/1/orders/3/products
    @GetMapping("/api/customers/{cId}/orders/{oId}/products")
    public List<OrderProduct> getAllOrderProductsBy(@PathVariable("cId") Integer customerId, @PathVariable("oId") Integer orderId) {
        return orderProductService.getAllBy(customerId, orderId);
    }

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProductsBySearchTerm(@RequestParam(name = "term") String searchString) {
        return productService.getBySearchTerm(searchString);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/api/customers/{customerId}/orders/{orderId}/products")
    @ResponseBody
    public OrderProduct addOrUpdateOrderProduct(@PathVariable int customerId, @PathVariable int orderId, @RequestBody OrderProduct orderProduct ){
        return orderProductService.addOrUpdateOrderProduct(customerId, orderId, orderProduct);
    }

    @RequestMapping(method =  RequestMethod.DELETE, path = "/api/customers/{customerId}/orders/{orderId}/products/{orderProductId}")
    public void deleteOrderProduct(@PathVariable int customerId, @PathVariable int orderId, @PathVariable int orderProductId ){
        orderProductService.delete(orderProductId);
    }

}