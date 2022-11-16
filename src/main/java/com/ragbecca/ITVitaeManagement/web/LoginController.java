package com.ragbecca.ITVitaeManagement.web;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.entity.vm.UserVM;
import com.ragbecca.ITVitaeManagement.validation.CurrentUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    UserVM handleLogin(@CurrentUser User loggedInUser) {
        return new UserVM(loggedInUser);
    }
}
