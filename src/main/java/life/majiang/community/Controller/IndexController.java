package life.majiang.community.Controller;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ljt
 * @create 2020-06-07-9:17
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        // 验证之前是否登录过
        // 如果登录过,根据token从数据库中取出来对应的user
        // 如果之前没有登录过,则到 /callback 存入cookie
        // 然后将user存入到Session中
        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        // 这样就实现了持久化登录
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        return "index";

    }

}
