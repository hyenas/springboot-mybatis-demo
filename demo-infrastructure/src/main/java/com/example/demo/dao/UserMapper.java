/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.example.demo.dao;
;
import java.util.List;

import com.example.demo.db.UserDO;
import com.example.demo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Eddú Meléndez
 */
@Mapper
public interface UserMapper {
	void addUser(UserDO user);
	UserDO getUserById(Long id);
	List<UserVO> listAllUsers();
}
