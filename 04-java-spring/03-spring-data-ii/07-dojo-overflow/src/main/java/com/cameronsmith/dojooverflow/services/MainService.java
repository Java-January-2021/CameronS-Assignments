package com.cameronsmith.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.dojooverflow.models.Answer;
import com.cameronsmith.dojooverflow.models.Question;
import com.cameronsmith.dojooverflow.models.Tag;
import com.cameronsmith.dojooverflow.repositories.AnswerRepo;
import com.cameronsmith.dojooverflow.repositories.QuestionRepo;
import com.cameronsmith.dojooverflow.repositories.TagRepo;

@Service
public class MainService {
	@Autowired
	private AnswerRepo aRepo;
	@Autowired
	private QuestionRepo qRepo;
	@Autowired
	private TagRepo tRepo;
//Question Methods
	//Create - Update
	public Question createQuestion(Question newEntry) {
		return this.qRepo.save(newEntry);
	}
	public Question updateQuestion(Question toUpdate) {
		return this.qRepo.save(toUpdate);
	}
	//Create with overloaded constructor
	public Question createQuestion(String question) {
		Question newEntry = new Question(question);
		return this.qRepo.save(newEntry);
	}
	public Question createQuestion(String question, List<Tag> tags) {
		Question newEntry = new Question(question,tags);
		return this.qRepo.save(newEntry);
	}
	//Add Tag to Question
	public void addTagToQuestion(Tag tag, Question question) {
		List<Tag> tags = question.getTags();
		tags.add(tag);
		this.qRepo.save(question);
	}
	//Add Answer to Question
	public void addAnswerToQuestion(Answer answer, Question question) {
		List<Answer> answers = question.getAnswers();
		answers.add(answer);
		this.qRepo.save(question);
	}
	//Read by ID-All
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	public Question getQuestionById(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	//Read Relationship Tables
	public List<Tag> getQuestionTags(){
		return this.getQuestionTags();
	}
	public List<Answer> getQuestionAnswers(){
		return this.getQuestionAnswers();
	}
	//Delete by ID
	public void deleteQuestionById(Long id) {
		this.qRepo.deleteById(id);
	}
	//Remove tag from Question
	public void removeTagFromQuestion(Tag tag, Question question) {
		List<Tag> tags = question.getTags();
		tags.remove(tag);
		this.qRepo.save(question);
	}
//Answer Methods
	//Create - Update
	public Answer createAnswer(Answer newEntry) {
		return this.aRepo.save(newEntry);
	}
	public Answer updateAnswer(Answer toUpdate) {
		return this.aRepo.save(toUpdate);
	}
	//Create with overloaded constructor
	public Answer createAnswer(String answer) {
		Answer newEntry = new Answer(answer);
		return this.aRepo.save(newEntry);
	}
	public Answer createAnswer(String answer, Question question) {
		Answer newEntry = new Answer(answer,question);
		return this.aRepo.save(newEntry);
	}
	//Read by ID-All
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
	public Answer getAnswerById(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	//Read Relationship Table
	public Question getAnswerQuestion(){
		return this.getAnswerQuestion();
	}
	//Delete by ID
	public void deleteAnswerById(Long id) {
		this.aRepo.deleteById(id);
	}
//Tag Methods
	//Create - Update
	public Tag createTag(Tag newEntry) {
		return this.tRepo.save(newEntry);
	}
	public Tag updateTag(Tag toUpdate) {
		return this.tRepo.save(toUpdate);
	}
	//Create with overloaded constructor
	public Tag createTag(String tags) {
		Tag newEntry = new Tag(tags);
		return this.tRepo.save(newEntry);
	}
	public Tag createTag(String tags, List<Question> question) {
		Tag newEntry = new Tag(tags,question);
		return this.tRepo.save(newEntry);
	}
	//Add Question to Tag
	public void addQuestionToTag(Tag tag, Question question) {
		List<Question> questions = tag.getQuestions();
		questions.add(question);
		this.tRepo.save(tag);
	}
	//Read by ID-All
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	public Tag getTagById(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	public Tag getTagByContains(String input) {
		Tag thisTag = this.tRepo.findBySubjectContaining(input);
		return thisTag;
	}
	//Read Relationship Tables
	public List<Question> getTagQuestions(){
		return this.getTagQuestions();
	}
	//Delete by ID
	public void deleteTagById(Long id) {
		this.tRepo.deleteById(id);
	}
	//Remove Question from Tag
	public void removeQuestionFromTag(Tag tag, Question question) {
		List<Question> questions = tag.getQuestions();
		questions.remove(question);
		this.tRepo.save(tag);
	}
	//Split Tag String from form Input
	//Save new tags and output list of tag objects? or strings of tags
	public ArrayList<Tag> splitTagString(String tagsInput){
		//create an array list of strings for split tagInput string output
		ArrayList<Tag> tagsOutput = new ArrayList<Tag>();
		//split taginput string at each comma
		for(String i: tagsInput.split(", ")) {
			System.out.println(i);
			//Check if tags are in DB
			if(this.getTagByContains(i) != null) {
				//if it is get that tag object
				Tag thisTag = this.getTagByContains(i);
				//Add  it to Array list 
				tagsOutput.add(thisTag);
			}else {
				//if its is not Save it as tag Object
				this.createTag(i);
				//get that tag object
				Tag thisTag = this.getTagByContains(i);
				//Add  it to Array list 
				tagsOutput.add(thisTag);
			}
		}
		//System.out.println(tagsOutput);
		return tagsOutput;
	}
	
	
}
