package com.backend.tripmate.restaurants.interfaces.rest;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.DeleteRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.backend.tripmate.restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.backend.tripmate.restaurants.domain.services.RestaurantCommandService;
import com.backend.tripmate.restaurants.domain.services.RestaurantQueryService;
import com.backend.tripmate.restaurants.interfaces.rest.resources.CreateRestaurantResource;
import com.backend.tripmate.restaurants.interfaces.rest.resources.RestaurantResource;
import com.backend.tripmate.restaurants.interfaces.rest.resources.UpdateRestaurantResource;
import com.backend.tripmate.restaurants.interfaces.rest.transform.CreateRestaurantCommandFromResourceAssembler;
import com.backend.tripmate.restaurants.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import com.backend.tripmate.restaurants.interfaces.rest.transform.UpdateRestaurantCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/restaurants", produces = APPLICATION_JSON_VALUE)
public class RestaurantController {

    private final RestaurantQueryService restaurantQueryService;
    private final RestaurantCommandService restaurantCommandService;

    private RestaurantController(RestaurantQueryService restaurantQueryService, RestaurantCommandService restaurantCommandService) {
        this.restaurantQueryService = restaurantQueryService;
        this.restaurantCommandService = restaurantCommandService;
    }

    @PostMapping
    public ResponseEntity<RestaurantResource> createRestaurant(@RequestBody CreateRestaurantResource resource) {
        try {
            var createRestaurantCommand = CreateRestaurantCommandFromResourceAssembler.toCommandFromResource(resource);
            var restaurant = restaurantCommandService.handle(createRestaurantCommand);
            var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurantResource);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<RestaurantResource>> getAllRestaurants() {
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        var restaurants = restaurantQueryService.handle(getAllRestaurantsQuery);
        var restaurantResources = restaurants.stream().map(RestaurantResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(restaurantResources);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResource> getRestaurantById(@PathVariable Long restaurantId) {
        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(restaurantId);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);
        if (restaurant.isEmpty()) return ResponseEntity.notFound().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResource> updateCourse(@PathVariable Long restaurantId, @RequestBody UpdateRestaurantResource resource) {
        var updateRestaurantCommand = UpdateRestaurantCommandFromResourceAssembler.toCommandFromResource(restaurantId, resource);
        var updatedRestaurant = restaurantCommandService.handle(updateRestaurantCommand);
        if (updatedRestaurant.isEmpty()) return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(updatedRestaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long restaurantId) {
        var deleteRestaurantCommand = new DeleteRestaurantCommand(restaurantId);
        restaurantCommandService.handle(deleteRestaurantCommand);
        return ResponseEntity.ok("Restaurant deleted successfully");
    }
}
