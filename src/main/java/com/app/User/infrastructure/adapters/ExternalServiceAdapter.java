package com.app.User.infrastructure.adapters;


import com.app.User.domain.models.AdicionalTarea;
import com.app.User.domain.ports.out.ExternoServicioPuerto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternoServicioPuerto {



    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdicionalTarea getAdicionalTarea(Integer tareaId) {
        String apiUrl = "https://jsonplaceholder.typecode.com/todos/"+ tareaId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if (todo == null){
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponse= restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();

        if (user ==null){
            return null;
        }
        return new AdicionalTarea(user.getId(),user.getNombre(),user.getEmail());

    }


    private static class JsonPlaceHolderTodo{
        private Integer id;
        private Integer userId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }
    }



    private static class JsonPlaceHolderUser{

        private Integer id;
        private String nombre;
        private String email;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }



}


