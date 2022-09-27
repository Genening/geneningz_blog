package geneningz.io.service.backup;

import geneningz.io.po.User;
import org.springframework.stereotype.Service;


/**
 * Created by Geneningz ZHANG on 9/20/2022.
 */
@Service
public interface UserService {

    User checkUser(String username, String password);

}
