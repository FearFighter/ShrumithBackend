package main.shruthi.amith.dao;

import model.Comment;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Comment> getAllComments() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Comment>  comments = session.createQuery("from comment").list();
		return comments;
	}

	@Override
	public Comment getComment(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		return comment;
	}

	@Override
	public Comment getCommentByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, name);
		return comment;
	}

	@Override
	public Comment addComment(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(comment);
		return comment;
	}

	@Override
	public void updateComment(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(comment);
		session.update(comment);
	}

	@Override
	public void deleteComment(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment p = session.load(Comment.class, id);
		if (null != p) {
			session.delete(p);
		}
	}

	@Override
	public void deleteCommentByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment p = session.load(Comment.class, name);
		if (null != p) {
			session.delete(p);
		}
	}
}
