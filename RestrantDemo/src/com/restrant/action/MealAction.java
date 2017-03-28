package com.restrant.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.MealBiz;
import com.restrant.biz.MealSeriesBiz;
import com.restrant.entity.Meal;
import com.restrant.entity.Pager;
public class MealAction  extends ActionSupport implements RequestAware{
	private Meal meal;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	MealBiz mealBiz;

	public void setMealBiz(MealBiz mealBiz) {
		this.mealBiz = mealBiz;
	}
	MealSeriesBiz mealSeriesBiz;

	public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
		this.mealSeriesBiz = mealSeriesBiz;
	}
	private Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	private File doc;
	private String docFileName;
	private String docContentType;
	Map<String, Object> request;

	public void setRequest(Map<String, Object> arg0) {
		this.request=request;
	}
	
	public String toShowMeal(){
		int curPage=1;
		if (pager!=null) {
			curPage=pager.getCurPage();
		}
		List mealList = null;
		if (meal!=null) {
			mealList = mealBiz.getMealByCondition(meal, curPage);
			pager = mealBiz.getPagerOfMeal(meal);
			if ((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null)) {
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			}
			if ((meal.getMealName()!=null)&&!meal.getMealName().equals("")) {
				request.put("mealName", meal.getMealName());
			}
		}else {
			mealList = mealBiz.getAllMeal(curPage);
			pager=mealBiz.getPagerOfMeal();
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "toShowMeal";
	}
	public String toAddMeal() throws Exception{
		List  mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "addMeal";
	}
	public String doAddMeal() throws Exception{
		if (docFileName!=null) {
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/mealimages");
			String targetFileName=generateFilename(docFileName);
			File target = new File(targetDirectory,targetFileName);
			FileUtils.copyFile(doc, target);
			meal.setMealImage(targetFileName);
			mealBiz.addMeal(meal);
		}
		return "toShowMeal";
	}

	private String generateFilename(String fileName) {
		String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate+random+extension;
	}
	public String toUpdateMeal(){
		//根据传入的id来获取更新的列表
		Meal updatedMeal = mealBiz.getMealByMealId(meal.getMealId());
		request.put("updatedMeal", updatedMeal);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "updateMeal";
	}
	public String doUpdateMeal() throws Exception{
		if (docFileName!=null) {
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/mealimages");
			String targetFileName=generateFilename(docFileName);
			File target = new File(targetDirectory,targetFileName);
			FileUtils.copyFile(doc, target);
			meal.setMealImage(targetFileName);
		}
		mealBiz.updateMeal(meal);
		return "toShowMeal";
	}
	public String deleteMeal(){
		mealBiz.deleteMeal(meal.getMealId());
		return "toManageMeal";
	}
}
