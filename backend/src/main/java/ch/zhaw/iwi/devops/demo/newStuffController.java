package ch.zhaw.iwi.devops.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newStuffController {
    private Map<Integer, Cars> car = new HashMap<>();
        @EventListener(ApplicationReadyEvent.class)
        public void init() {
            this.car.put(1,new Cars(1, "Toyota Yaris TS"));
            this.car.put(2,new Cars(2, "Suzuki Alto"));
            this.car.put(3,new Cars(3, "VW Passat"));
            System.out.println("Init Data");
        }
        @GetMapping("/car/{id}")
            public Cars getPerson(@PathVariable Integer id) {
            return this.car.get(id);
}
    

    @PostMapping("/car")
    public void createCars(@RequestBody Cars car) {
        var newId = this.car.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        car.setId(newId);
        this.car.put(newId, car);
    }
    @PutMapping("/car/{id}")
    public void updateCars(@PathVariable Integer id, @RequestBody Cars car) {
        car.setId(id);
        this.car.put(id, car);
    }
    @DeleteMapping("/car/{id}")
        public Cars deleteCars(@PathVariable Integer id) {
        return this.car.remove(id);
    }
}
