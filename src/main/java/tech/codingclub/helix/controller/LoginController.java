package tech.codingclub.helix.controller;

import org.apache.log4j.Logger;
import org.jooq.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.codingclub.helix.database.GenericDB;
import tech.codingclub.helix.entity.Member;
import tech.codingclub.helix.entity.signupResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tech.codingclub.helix.entity.LoginResponse;
import java.util.List;

/**
 * User: rishabh
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String adminLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminLogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String userlLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "userLogin";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "welcomelogin";
    }



    @RequestMapping(method = RequestMethod.POST, value = "/welcome")
    public
    @ResponseBody
    LoginResponse handlelogin(@RequestBody Member member, HttpServletRequest request, HttpServletResponse response) {

       Condition condition  =tech.codingclub.helix.tables.Member.MEMBER.EMAIL.eq(member.email).and(tech.codingclub.helix.tables.Member.MEMBER.PASSWORD.equal(member.password));

        List<Member>x= (List<Member>)GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER, Member.class,condition,1);
        if (x != null && x.size()> 0) {
            Member membertemp =x.get(0);
            membertemp.role="cm";
            ControllerUtils.setUserSession(request,membertemp);
            return new LoginResponse(membertemp.id,true,"logined successfully !");
        } else{
            return new LoginResponse(null,false," wrong combination ! ");
        }

    }
}