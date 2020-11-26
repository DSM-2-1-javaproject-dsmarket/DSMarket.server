package com.dsmarket.server.services.post;


import com.dsmarket.server.dto.CreatePostForm;
import com.dsmarket.server.dto.UpdatePostDto;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.entities.post.repository.PostRepository;
import com.dsmarket.server.exeptions.AccessDeniedException;
import com.dsmarket.server.exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    public Post createPost(CreatePostForm postInfo){

        Date now = new Date();

        Post newPost = Post
                .builder()
                .postDate(now)
                .postType(postInfo.getPostType())
                .wroteAccount(postInfo.getPostAccount())
                .price(postInfo.getPrice())
                .item(postInfo.getItem())
                .tag(postInfo.getTag())
                .content(postInfo.getContent())
                .build();

        return postRepository.save(newPost);
    }


    public Post getPost(Integer id){
        return postRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public List<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable).toList();
    }


    public void checkPostEditAuthorization(Account account, Post post){
        if(!account.equals(post.getWroteAccount())){
            throw new AccessDeniedException();
        }
    }


    public void deletePost(Post post){
        postRepository.delete(post);
    }

    public Post updatePost(Post post, UpdatePostDto postInfo){
        Post updatedPost = Post
                .builder()
                .postDate(post.getPostDate())
                .postType(postInfo.getPostType())
                .wroteAccount(postInfo.getPostAccount())
                .price(postInfo.getPrice())
                .item(postInfo.getItem())
                .tag(postInfo.getTag())
                .id(post.getId())
                .finished(post.getFinished())
                .view(post.getView())
                .build();


        return postRepository.save(updatedPost);
    }
}
