package com.remesh.interview.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.remesh.interview.dto.QueryParam;
import com.remesh.interview.dto.Users;

public class UsersPredicates {

	public static Predicate<Users> getIncomePredicate(String income) {

		List<Predicate<Users>> incomePredicates = new ArrayList<>();
		if (income.contains("AND")) {

			String[] incomeArray = income.split("AND");
			Predicate<Users> p;
			for (String s : incomeArray) {
				p = x -> x.getIncome().equals(s.trim());
				incomePredicates.add(p);
			}
			return incomePredicates.stream().reduce(x -> true, Predicate::and);
		} else if (income.contains("OR")) {

			String[] incomeArray = income.split("OR");
			Predicate<Users> p;
			for (String s : incomeArray) {
				p = x -> x.getIncome().equals(s.trim());
				incomePredicates.add(p);
			}
			return incomePredicates.stream().reduce(x -> true, Predicate::or);
		} else {
			return x -> x.getIncome().equals(income.trim());
		}
	}

	public static Predicate<Users> getAgePredicate(String age) {

		List<Predicate<Users>> agePredicates = new ArrayList<>();
		if (age.contains("AND")) {

			String[] ageArray = age.split("AND");
			Predicate<Users> p;
			for (String s : ageArray) {
				p = x -> x.getAge().equals(s.trim());
				agePredicates.add(p);
			}
			return agePredicates.stream().reduce(x -> true, Predicate::and);
		} else if (age.contains("OR")) {

			String[] ageArray = age.split("OR");
			Predicate<Users> p;
			for (String s : ageArray) {
				p = x -> x.getAge().equals(s.trim());
				agePredicates.add(p);
			}
			return agePredicates.stream().reduce(x -> true, Predicate::or);
		} else {
			return x -> x.getAge().equals(age.trim());
		}
	}

	public static Predicate<Users> getSexPredicate(String sex) {

		List<Predicate<Users>> sexPredicates = new ArrayList<>();
		if (sex.contains("AND")) {

			String[] sexArray = sex.split("AND");
			Predicate<Users> p;
			for (String s : sexArray) {
				p = x -> x.getSex().equals(s.trim());
				sexPredicates.add(p);
			}
			return sexPredicates.stream().reduce(x -> true, Predicate::and);
		} else if (sex.contains("OR")) {

			String[] sexArray = sex.split("OR");
			Predicate<Users> p;
			for (String s : sexArray) {
				p = x -> x.getSex().equals(s.trim());
				sexPredicates.add(p);
			}
			return sexPredicates.stream().reduce(x -> true, Predicate::or);
		} else {
			return x -> x.getSex().equals(sex.trim());
		}
	}

	public static Predicate<Users> getLEPredicate(String le) {

		List<Predicate<Users>> lePredicates = new ArrayList<>();
		if (le.contains("AND")) {

			String[] leArray = le.split("AND");
			Predicate<Users> p;
			for (String s : leArray) {
				p = x -> x.getLivingEnvironment().equals(s.trim());
				lePredicates.add(p);
			}
			return lePredicates.stream().reduce(x -> true, Predicate::and);
		} else if (le.contains("OR")) {

			String[] leArray = le.split("OR");
			Predicate<Users> p;
			for (String s : leArray) {
				p = x -> x.getLivingEnvironment().equals(s.trim());
				lePredicates.add(p);
			}
			return lePredicates.stream().reduce(x -> true, Predicate::or);
		} else {
			return x -> x.getLivingEnvironment().equals(le.trim());
		}
	}

	public static Predicate<Users> createUsersPredicate(QueryParam queryParam) {

		List<Predicate<Users>> allUsersPredicates = new ArrayList<>();

		if (null != queryParam.getIncome() && !queryParam.getIncome().equals("")) {
			allUsersPredicates.add(getIncomePredicate(queryParam.getIncome()));
		}
		if (null != queryParam.getAge() && !queryParam.getAge().equals("")) {
			allUsersPredicates.add(getAgePredicate(queryParam.getAge()));
		}
		if (null != queryParam.getSex() && !queryParam.getSex().equals("")) {
			allUsersPredicates.add(getSexPredicate(queryParam.getSex()));
		}
		if (null != queryParam.getLivingEnvironment() && !queryParam.getLivingEnvironment().equals("")) {
			allUsersPredicates.add(getLEPredicate(queryParam.getLivingEnvironment()));
		}

		Predicate<Users> compositePredicate = allUsersPredicates.stream().reduce(x -> true, Predicate::and);

		return compositePredicate;

	}
}
