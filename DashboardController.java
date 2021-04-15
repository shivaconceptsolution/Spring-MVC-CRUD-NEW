package bao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.Register;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public ModelAndView dashboardLoad()
	{
		return new ModelAndView("dashboard");
	}
	@RequestMapping("/edit")
	public ModelAndView dashboardEdit(HttpServletRequest request, HttpServletResponse response )
	{
		
		ModelAndView mv = new ModelAndView("editreg");
		mv.addObject("res",request.getParameter("q"));
		return mv;
	}
	@RequestMapping("/updatereg")
	public ModelAndView dashboardUpdate(HttpServletRequest request, HttpServletResponse response )
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx = s.beginTransaction();
	    Register r =(Register) s.load(Register.class,new Integer(request.getParameter("txtid")));
	    r.setEmailid(request.getParameter("txtemail"));
	    r.setPassword(request.getParameter("txtpass"));
	    s.save(r);
	    tx.commit();
		return new ModelAndView("redirect:dashboard");
	}
	
}
