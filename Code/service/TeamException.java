package pym.project.test2.service;

/**
 * ClassName: TeamException
 * Package: pym.project.test2.service
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/12 15:14
 * @Version: 1.0
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -338751124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
