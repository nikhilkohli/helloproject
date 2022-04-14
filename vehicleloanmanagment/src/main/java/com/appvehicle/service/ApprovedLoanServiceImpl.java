package com.appvehicle.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.ApprovedLoansJPARepository;
import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.InvalidDetailsException;
import com.appvehicle.exceptions.LoanApplicationException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.ApprovedLoansEntity;
import com.appvehicle.service.EmiService;
import com.appvehicle.service.EmiServiceImpl;

@Service
public class ApprovedLoanServiceImpl implements ApprovedLoanService 
{
    
    static Logger log = Logger.getLogger(ApprovedLoanServiceImpl.class.getClass());
    
    EmiServiceImpl emiService = new EmiServiceImpl();
    
    
 	

    
    @Autowired
    private ApprovedLoansJPARepository approvedRepo;
 
    
    //GET APPROVED BY LOANID
        @Override
        public ApprovedLoansEntity showApprovedByLoanId(int loanId) throws RecordNotFoundException
        {
 
            log.info("Service Layer - Entry - showAllApprovedByEmail");
            
            Optional<ApprovedLoansEntity> approved = approvedRepo.findById(loanId);
            if(!approved.isPresent())
            {
                log.warn("WARN:  LoanId should not be match");
                throw new RecordNotFoundException("LoanId should not be match");
            }
            log.info("Service Layer - Exit - showApprovedByLoanId");
            return approved.get();    
        }
 
    //GET APPROVED BY EMAIL
    @Override
    public List<ApprovedLoansEntity> showAllApprovedByEmail(String email) throws RecordNotFoundException 
    {
 
        log.info("Service Layer - Entry - showAllApprovedByEmail");
        
        if(email==null)
        {
            log.warn("WARN:  Email should not match");
            throw new RecordNotFoundException("Email should not match");
        }
        
        log.info("Service Layer - Exit - showAllApprovedByEmail");
        return approvedRepo.findAll();
    
    }
 
    @Override
    public List<ApprovedLoansEntity> addApprovedLoan(ApprovedLoansEntity approved) throws DuplicateRecordException, InvalidDetailsException {
    	
    	
    	if(approved==null)
    		throw new InvalidDetailsException("Invalid Object Found!");
    	if(!(approved.getLoanapp().getStatus().equalsIgnoreCase("Accepted")))
 
    	{	
    	double loanAmount=approved.getLoanapp().getAmount();   
    	int tenure=approved.getLoanapp().getTenure();
    	double interestRate=approved.getLoanapp().getInterest();
    	
    	System.out.println("function is called");
 
    	double emi=emiService.EMICalculate(loanAmount, tenure, interestRate);
    	
    	
    	approved.setEmi(emi);   
    	}
    	
    	  Optional<ApprovedLoansEntity> retApproved=approvedRepo.findById(approved.getLoanId());     
    	if(retApproved.isPresent())
    		throw new DuplicateRecordException("The Loan is already added");
    	approvedRepo.saveAndFlush(approved);
    	return approvedRepo.findAll();
    	
    	                                                                                                      
    }
    
	@Override
    public List<ApprovedLoansEntity> showall() {
    	// TODO Auto-generated method stub
    	return approvedRepo.findAll();
    }


    
}