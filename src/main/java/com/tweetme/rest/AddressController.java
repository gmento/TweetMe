package com.tweetme.rest;


import com.tweetme.domain.Address;
import com.tweetme.service.AddressService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "address", description = "Address API")
public class AddressController extends AbstractRestHandler {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/address",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    public List<Address> getAddresses() {
        return addressService.getAddress();
    }

    @RequestMapping(value = "/address",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> processRegistration(@Valid
                                                       @RequestBody
                                                       final Address address) {
        final Address savedAddress = addressService.createAddress(address);

        final HttpHeaders headers = new HttpHeaders();
        final URI locationUri = ServletUriComponentsBuilder
                .fromCurrentServletMapping().path("/api/v1/address/")
                .path(String.valueOf(savedAddress.getId()))
                .build()
                .toUri();

        headers.setLocation(locationUri);

        final ResponseEntity<Address> responseEntity =
                new ResponseEntity<>(savedAddress, headers, HttpStatus.CREATED);
        return responseEntity;
    }


    @RequestMapping(value = "/address/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Address showAddressDetails(@PathVariable
                                      final Integer id) {

        return addressService.getAddressById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/address/{id}",
            method = RequestMethod.DELETE)
    public void deleteAddressById(@PathVariable
                                  final Integer id) {

        addressService.deleteAddress(id);
    }

    @RequestMapping(value = "/address",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@Valid
                              @RequestBody
                              final Address address) {

        addressService.updateAddress(address);
    }

}
