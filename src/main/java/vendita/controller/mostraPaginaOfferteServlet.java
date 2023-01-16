package vendita.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import registrazione.Utente;

import java.io.IOException;

/**
 * La classe permette l'indirizzamento verso la pagina di mie offerte
 * @author Salvatore Sautariello
 */


@WebServlet(name = "mostraPaginaOfferteServlet", value = "/mostraPaginaOfferteServlet")
public class mostraPaginaOfferteServlet extends HttpServlet {
    /**
     * Il metodo permette di gestire la richiesta del client,dove il server
     * rimanda alla pagina di vendita tramite parametro RequestDispatcher .
     * @param req : oggetto di richiesta HTTP
     * @param resp : oggetto di risposta HTTP
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String address = "";
        Utente utente = (Utente) session.getAttribute("Utente");

        if(utente == null)
            address ="/WEB-INF/results/login.jsp";

        else
            address ="/WEB-INF/results/myoffers.jsp";

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}
