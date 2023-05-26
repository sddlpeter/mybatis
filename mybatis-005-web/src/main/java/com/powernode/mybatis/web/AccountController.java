package com.powernode.mybatis.web;

import com.powernode.mybatis.exception.AppException;
import com.powernode.mybatis.exception.MoneyNotEnoughException;
import com.powernode.mybatis.service.AccountService;
import com.powernode.mybatis.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/transfer")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromAcct = request.getParameter("fromAcct");
        String toAcct = request.getParameter("toAcct");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            accountService.transfer(fromAcct, toAcct, money);
            response.sendRedirect("/bank/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect("/bank/moneyNotEnough.html");
        } catch (AppException e) {
            response.sendRedirect("/bank/transferFailure.html");
        }

    }
}
