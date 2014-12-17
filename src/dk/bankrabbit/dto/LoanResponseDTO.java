/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.bankrabbit.dto;

import java.io.Serializable;

/**
 *
 * @author marekrigan
 */
public class LoanResponseDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private double interestRate;
    private String ssn;
    
    public LoanResponseDTO()
    {
    }
    
    public LoanResponseDTO(double interestRate, String ssn)
    {
        this.interestRate = interestRate;
        this.ssn = ssn;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "LoanResponseDTO{" + "interestRate=" + interestRate + ", ssn=" + ssn + '}';
    }
    
    
    
}
