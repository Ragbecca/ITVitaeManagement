package com.ragbecca.ITVitaeManagement.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.util.Views;
import com.ragbecca.ITVitaeManagement.validation.CurrentUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    @JsonView(Views.Base.class)
    User handleLogin(@CurrentUser User loggedInUser) {
        return loggedInUser;
    }
}
