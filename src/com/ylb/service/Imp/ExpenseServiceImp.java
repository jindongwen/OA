package com.ylb.service.Imp;

import com.ylb.entity.Expense;
import com.ylb.mapper.ExpenseMapper;
import com.ylb.service.ExpenseService;
import com.ylb.util.DBUtil;

public class ExpenseServiceImp  implements ExpenseService {

    @Override
    public int ExpenseSave(Expense expense) {
        ExpenseMapper mapper = DBUtil.getSqlSession().getMapper(ExpenseMapper.class);
        int i = mapper.expenseAdd(expense);
        DBUtil.closeSqlSession();
        return i;
    }
}
