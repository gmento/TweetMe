package com.tweetme.rest;


import com.tweetme.domain.UserProfile;
import com.tweetme.service.UserProfileService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "userprofile", description = "UserProfile API")
public class UserProfileController extends AbstractRestHandler {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/userprofile",
            method = RequestMethod.GET)
            //consumes = MediaType.APPLICATION_JSON_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfile();
    }

    @RequestMapping(value = "/userprofile",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> processRegistration(@Valid
                                                       @RequestBody
                                                       final UserProfile userProfile) {
        final UserProfile savedUserProfile = userProfileService.createUserProfile(userProfile);

        final HttpHeaders headers = new HttpHeaders();
        final URI locationUri = ServletUriComponentsBuilder
                .fromCurrentServletMapping().path("/api/v1/address/")
                .path(String.valueOf(savedUserProfile.getId() ) )
                .build()
                .toUri();

        headers.setLocation(locationUri);

        final ResponseEntity<UserProfile> responseEntity =
                new ResponseEntity<>(savedUserProfile, headers, HttpStatus.CREATED);
        return responseEntity;
    }


    @RequestMapping(value = "/userprofile/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:8080")
    public UserProfile showUserProfileDetails(@PathVariable
                                      final Long id) {
    	
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    	if (principal instanceof UserDetails) {
    	  String username = ((UserDetails)principal).getUsername();
    	} else {
    	  String username = principal.toString();
    	}
    	
    	
        return userProfileService.getUserProfileById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/userprofile/{id}",
            method = RequestMethod.DELETE)
    public void deleteUserProfileById(@PathVariable
                                  final Long id) {

        userProfileService.deleteUserProfile(id);
    }

    
    @RequestMapping(value = "/userprofile",
            		method = RequestMethod.PUT,
            		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateUserProfile(@Valid
                              @RequestBody
                              final UserProfile userProfile) {

        userProfileService.updateUserProfile(userProfile);
    }
    
    

}
