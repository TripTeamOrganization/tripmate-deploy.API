package com.backend.tripmate.importabledata;

import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;



@Service
public class MyImportServiceClient {

    @Autowired
    private ImportService importService;

    public void importRestaurants() {
        List<Restaurant> restaurants = Arrays.asList(
                new Restaurant("Restaurante del Mar", "https://digital.ihg.com/is/image/ihg/intercontinental-san-pedro-sula-9491316547-16x9", "Playa Serena - $$$", "Especialidad: Mariscos frescos"),
                new Restaurant("Café Aroma", "https://www.barcelonaculinaryhub.com/sites/bch.com/files/styles/img_style_max_500/public/images/inteligencia-artificial-gastronomia%20%282%29_1.png?itok=Cs2quEHi", "Centro Histórico - $", "Especialidad: Café gourmet"),
                new Restaurant("Bar del Puerto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP7pmG70guP8AaYx3szDZ6c_TvbxSpbWZygQ&s", "Puerto Viejo - $$", "Especialidad: Cocteles tropicales"),
                new Restaurant("Parrilla Argentina", "https://cache.marriott.com/is/image/marriotts7prod/jw-saojw-neto-restaurant-20912:Feature-Hor?wid=1920&fit=constrain", "Barrio Latino - $$$", "Especialidad: Asado argentino"),
                new Restaurant("Sushi Fusion", "https://imagenes.heraldo.es/files/image_990_556/uploads/imagenes/2023/04/10/restaurante-utopico-de-zaragoza.jpeg", "Distrito Oriental - $$", "Especialidad: Sushi creativo"),
                new Restaurant("La Pizzeria Italiana", "https://loyicard.com/wp-content/uploads/2024/04/Fidelizacion-para-restaurantes.png", "Plaza Mayor - $$", "Especialidad: Pizza italiana"),
                new Restaurant("Thai Spice", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrfwgdaJBwIILTI-zSURu7rwlKQg6592p-EQ&s", "Centro Comercial - $$", "Especialidad: Comida tailandesa"),
                new Restaurant("Le Bistro Français", "https://loyicard.com/wp-content/uploads/2024/04/Fidelizacion-para-restaurantes.png", "Avenida Principal - $$$", "Especialidad: Cocina francesa"),
                new Restaurant("El Asador Mexicano", "https://loyicard.com/wp-content/uploads/2024/04/Fidelizacion-para-restaurantes.png", "Zona Norte - $$", "Especialidad: Carne asada mexicana"),
                new Restaurant("Vegetariano Verde", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhCg7g-B80K9-KdSOSShygWB6fO5Uib1BXUw&s", "Distrito Saludable - $", "Especialidad: Comida vegetariana")
        );


        importService.importRestaurants(restaurants);
        System.out.println("Datos importados correctamente para: Restaurant");
    }
    public void importActivities() {
        List<Activity> activities = Arrays.asList(
                new Activity("Hiking Adventure", "https://actividadesturismo.com/wp-content/uploads/2024/02/portada-actividades-turismo.jpg", "Explore scenic trails in the mountains", "Mountain Range", "$$"),
                new Activity("City Bike Tour", "https://d1xw84ija6gjgy.cloudfront.net/production/5b685c54b72bac34e7b56feb9f7be2c5/conversions/HD.jpg", "Guided tour around historical landmarks", "City Center", "$"),
                new Activity("Cooking Class", "https://media.istockphoto.com/id/1426350161/photo/hands-cutting-onion-in-the-kitchen.jpg?s=612x612&w=0&k=20&c=liW0VpaKXgT8Lm-Qszry-MCwKcOcppzP6F_Ftu2pB6M=", "Learn to prepare local dishes with a chef", "Culinary School", "$$$"),
                new Activity("Surfing Lessons", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzydS6xTKNEj73f5TES_2JCpl0gclVMQ4sFw&s", "Catch waves with experienced instructors", "Beachfront", "$$"),
                new Activity("Wine Tasting", "https://media.istockphoto.com/id/1460761498/photo/pouring-different-wines-into-the-glasses-arranged-for-the-wine-tasting-on-the-counter.jpg?s=612x612&w=0&k=20&c=oVy-iR76yZHoqpx_Rk2TUTSjNl2rY-inoSzcXT_wp4Y=", "Sample exquisite wines at local vineyards", "Wine Country", "$$$"),
                new Activity("Art Museum Tour", "https://media.timeout.com/images/105625670/image.jpg", "Discover classic and contemporary art collections", "Downtown", "$"),
                new Activity("Zip-lining Adventure", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Texas_Zip_liner_5430.JPG/1200px-Texas_Zip_liner_5430.JPG", "Thrilling zip-line experience through the forest", "Adventure Park", "$$$"),
                new Activity("Sailing Excursion", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr6BtRBqq-4Vd1K__81ARUTDp5IEkU-yuvTg&s", "Enjoy a relaxing day on a sailboat", "Marina", "$$$"),
                new Activity("Historical Walking Tour", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkv4970iYynxK4PmNwtfa85T_-QLxQ98WiOg&s", "Explore the city's rich history with a guide", "Historical District", "$"),
                new Activity("Scuba Diving Expedition", "https://media.istockphoto.com/id/1360323358/photo/scuba-divers-couple-near-beautiful-coral-reef-surrounded-with-shoal-of-coral-fish-and-three.jpg?s=612x612&w=0&k=20&c=Slr1T3dmRFmUJnZmeQRAwhaG0wWhGrQPgmceWyaWorM=", "Dive into colorful coral reefs and marine life", "Coastal Waters", "$$$")
        );

        importService.importActivities(activities);
        System.out.println("Activities imported successfully.");
    }
    public void importAccommodations() {
        List<Accommodation> accommodations = Arrays.asList(
                new Accommodation("Delfines Hotel & Convention Center", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/172550030.jpg?k=926a97cba96ba42af2becee00581caaa9db683e0d5e4ea196e5f710823311581&o=&hp=1", "Ubicado en el distrito financiero de San Isidro de Lima, el Delfines Hotel & Convention Center es un complejo exclusivo que ofrece instalaciones de spa excelentes y WiFi gratis. Con una reputación por su servicio excepcional y comodidades de lujo, este hotel es la opción ideal para viajeros que buscan una experiencia inolvidable en Lima.", "a 6 km del centro", "S/ 543 ó $145.11 por noche"),
                new Accommodation("Sheraton Lima Historic Center", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/343347284.jpg?k=f33417b6eb96b6b150ec1ec3ce6ff544571e87c6d045deac6465e24785b5520b&o=&hp=1", "El Sheraton Lima Historic Center es un hotel de lujo ubicado en el corazón de Lima. Con una piscina y un centro de fitness, ofrece habitaciones amplias con vistas impresionantes a la ciudad y comodidades modernas para una estadía confortable. Su ubicación privilegiada lo convierte en una opción popular para viajeros que desean explorar los lugares de interés histórico de la ciudad.", "a 4.5 km del centro", "S/ 353 ó $94.34 por noche"),
                new Accommodation("Padama Hotel", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/38338804.jpg?k=d2323474c802cf8980bfaf0291ad83ba9332c32980dcf1ad142c9ad83e7887e2&o=&hp=1", "El Padama Hotel ofrece alojamiento conveniente en Lima, a solo unos minutos del aeropuerto internacional Jorge Chávez. Con conexión WiFi gratuita y habitaciones cómodas equipadas con todo lo necesario para una estadía agradable, es una excelente opción tanto para viajeros de negocios como de placer.", "a 1 km del centro", "S/ 124 ó $33.14 por noche"),
                new Accommodation("Sonesta Hotel El Olivar Lima", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/342980422.jpg?k=1a93412556c1a5255a597c7c26e31957a6defb6c5c0b494f729680d6ccc66242&o=&hp=1", "Este lujoso hotel está estratégicamente ubicado junto al bosque El Olivar, en el corazón del distrito financiero de San Isidro en Lima.", "a 6 km del centro", "S/ 400 ó $107.02 por noche"),
                new Accommodation("The Secret Garden Hostel", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/389314832.jpg?k=5c8ca634072820dd9a990b487c7cf7113c5a8456300e4fa464808423fc613ade&o=&hp=1", "Con una ubicación privilegiada junto al bosque El Olivar, el Sonesta Hotel El Olivar Lima ofrece una experiencia de lujo en el distrito financiero de San Isidro. Sus habitaciones espaciosas, instalaciones modernas y atención al detalle hacen de este hotel una opción ideal para viajeros exigentes.", "a 5 km del centro", "S/ 150 ó $40.13 por noche"),
                new Accommodation("Iberostar Selection Miraflores", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/330101201.jpg?k=3e5a3e0988c65cc445c1e5796a6832f15681a63f6fc282e06795578bcb604af8&o=&hp=1", "Situado en el vibrante distrito de Miraflores, el Iberostar Selection Miraflores ofrece a sus huéspedes una experiencia de lujo con piscina al aire libre, gimnasio y terraza con impresionantes vistas. Sus modernas instalaciones y su servicio de primera clase garantizan una estadía inolvidable en Lima.", "a 4 km del centro", "S/ 600 ó $160.53 por noche"),
                new Accommodation("Casa Matara Boutique", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/198172708.jpg?k=9e5f262082a204fe066d8c300cefc81e78921da1cd1f000a7f216158062d0287&o=&hp=1", "Con una ubicación céntrica en Cuzco, la Casa Matara Boutique es un refugio elegante con servicio excepcional y un ambiente acogedor. Idealmente situado cerca de los principales lugares de interés de la ciudad, es perfecto para los viajeros que desean explorar la rica historia y cultura de Cuzco.", "a 0.5 km del centro", "S/ 200 ó $53.51 por noche"),
                new Accommodation("Tierra Viva Miraflores Centro", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/200400736.jpg?k=965ce5b582e4340ed52089caa4c110f87fc91a42b670741068cbff8604df8910&o=&hp=1", "Tierra Viva Miraflores Centro ofrece comodidad y conveniencia en el corazón de Lima. Con WiFi gratuito y estacionamiento privado, sus habitaciones acogedoras y su servicio amable garantizan una estancia agradable para los viajeros que buscan explorar la ciudad.", "a 5 km del centro", "S/ 250 ó $66.89 por noche"),
                new Accommodation("Ayenda La Luna Inn", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/33/f6/a5/hotel-la-luna-inn.jpg?w=700&h=-1&s=1", "Ayenda La Luna Inn es un hotel acogedor en Lima, ideal para viajeros que buscan una estadía cómoda y asequible. Con un bar animado y habitaciones bien equipadas, ofrece una experiencia auténtica en la ciudad.", "a 5 km del centro", "S/ 180 ó $48.11 por noche"),
                new Accommodation("INNSiDE by Meliá Lima Miraflores", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/213385437.jpg?k=1c596e30a0f1aa84f525a663b465f58b07deb1a8e790c2ec91a73e7473c23fa8&o=&hp=1", "Ubicado cerca del centro comercial Larcomar en Lima, el INNSiDE by Meliá Lima Miraflores ofrece una combinación perfecta de estilo moderno y comodidades de lujo. Con una piscina al aire libre y un ambiente sofisticado, es ideal para viajeros que buscan una experiencia de alta gama en la ciudad.", "a 3 km del centro", "S/ 550 ó $147.12 por noche")
        );

        importService.importAccommodations(accommodations);
        System.out.println("Accommodations imported successfully.");
    }

    public void importFlights() {
        List<Flight> flights = Arrays.asList(
                new Flight("JetSmart", "https://logowik.com/content/uploads/images/jetsmart8250.logowik.com.webp", "Internacional", "Desde $198"),
                new Flight("Sky", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SXDa6DG9AGDGBu0uLd324LbOoIlhk7fyvCz54mBcNw&s", "Internacional", "Desde $200"),
                new Flight("Avianca", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTew9cA4sqCq-pIi9oAXxIIZdtkzqCLJEno-iQ8zdu_Aw&s", "Internacional", "Desde $223"),
                new Flight("StarPeru", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCHpaM58ypxgXwa6uoQEGrt3TzuodV25OkWU6CLUPQsA&s", "Internacional", "Desde $283"),
                new Flight("Latam", "https://pbs.twimg.com/profile_images/1675869346256637953/FqzPqQeh_400x400.jpg", "Internacional", "Desde $310"),
                new Flight("Viva Air", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5cMWz-z9cA6qAA0HQtei0oVYtNXQCmi9rtoC6rlI_wg&s", "Nacional", "Desde $80"),
                new Flight("Peruvian Airlines", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeQsk_JnjVE5_DDdFY0LWLYCB1JEufWJFKJan41oXQrQ&s", "Nacional", "Desde $120"),
                new Flight("LC Perú", "https://pbs.twimg.com/profile_images/534343971745452032/qnK_qgmU_400x400.png", "Nacional", "Desde $140"),
                new Flight("American Airlines", "https://upload.wikimedia.org/wikipedia/commons/e/ea/American_Airlines_Boeing_787-8_landing_at_LAX.jpg", "Internacional", "Desde $350")
        );

        importService.importFlights(flights);
        System.out.println("Flights imported successfully.");
    }

}