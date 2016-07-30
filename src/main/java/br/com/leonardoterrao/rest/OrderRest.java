package br.com.leonardoterrao.rest;

import br.com.leonardoterrao.model.Customer;
import br.com.leonardoterrao.model.Order;
import br.com.leonardoterrao.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Named
@Path("/")
public class OrderRest {

    private static long id = 1;

    @Autowired
    private RestTemplate restTemplate;

    @GET
    @Path("order")
    @Produces(MediaType.APPLICATION_JSON)
    public Order submitOrder(@QueryParam("idCustomer") Long idCustomer,
                             @QueryParam("idProduct") Long idProduct,
                             @QueryParam("amount") Long amount) {

        final Customer customer = restTemplate.getForObject("http://localhost:8081/customer?id={id}", Customer.class, idCustomer);
        final Product product = restTemplate.getForObject("http://localhost:8082/product?id={id}", Product.class, idProduct);
        final Order order = Order.builder()
                .id(id)
                .customer(customer)
                .product(product)
                .amount(amount)
                .date(LocalDateTime.now())
                .build();
        id++;

        return order;
    }

}
