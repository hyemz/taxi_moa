import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import styles from './Toolbar.module.css';

function Hello() {
  const [users, setUsers] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        // 요청이 시작 할 때에는 error 와 users 를 초기화하고
        setError(null);
        setUsers(null);
        // loading 상태를 true 로 바꿉니다.
        setLoading(true);
        const response = await axios.get(
          'http://220.118.36.168:9100/api/lottenc/kakao', {withCredentials: true}
        );
        setUsers(response.data); // 데이터는 response.data 안에 들어있습니다.
      } catch (e) {
        //console.log(e);
        setError(e);
      }
      setLoading(false);
    };

    fetchUsers();
  }, []);

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return null;
  return (
    <ul>
      {users.map(user => (
        
        <li key={user.id}>
          <div>
            <Card style={{ width: '18rem' }}>
              <Card.Body>
                <div className={styles.CardDiv}>
                  <Card.Title className={styles.CardTitle}>{user.member_identifier}</Card.Title>
                  <Card.Text>
                    <div className={styles.CardText} >
                    {user.call_time} <br/>
                    {user.departure_point} → {user.arrival_point}<br/></div>
                    <div className={styles.CardText2}>{user.service_fare}원 </div>
                  </Card.Text>
                  <Card.Link href="#">사유입력</Card.Link>
                </div>
              </Card.Body>
            </Card>
          </div>
        </li>
      ))}
    </ul>
  );
}

export default Hello;