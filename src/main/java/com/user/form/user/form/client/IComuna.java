package com.user.form.user.form.client;

import com.user.form.user.form.dto.ComunaDto;
import com.user.form.user.form.dto.RequestComuna;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "getcomuna",url = "${request.comuna}")
public interface IComuna {
    @GetMapping(value = "/comunas", consumes = MediaType.APPLICATION_JSON_VALUE)
        List<RequestComuna> getComuna();


}
