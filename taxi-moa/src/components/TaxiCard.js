import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Carousel from 'react-bootstrap/Carousel';
import styles from './TaxiCard.module.css';
import Loading from './Loading';

function chunk(arr, size) {
  var i, j, temparray = [], chunk = size;
  for (i = 0, j = arr.length; i < j; i += chunk) {
      temparray.push(arr.slice(i, i + chunk));
  }
  return temparray
}


function TaxiCard() {
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

  if (loading) return <div><Loading/></div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return null;
  console.log("size = " + users.length);
  let tusers = chunk(users, 3);
  return (
    <ul className={styles.TaxiCardUl}>
        {users.map(user => (
          <li key={user.id} className={styles.TaxiCardLi}>
            <div className={styles.CardDiv}>
              <Button variant="primary">
                <Card style={{ width: '18rem'}}>
                  <Card.Body>
                    <Card.Title className={styles.CardTitle}>{user.member_identifier}</Card.Title>
                    <Card.Text>
                      <table className={styles.TaxiCardTable}>
                        <tr className={styles.CardText}> {user.call_time} </tr>
                        <tr className={styles.CardText}> {user.departure_point} → {user.arrival_point} </tr>
                        <tr className={styles.CardText2}> {user.service_fare}원<br/></tr>
                        <tr className={styles.CardText2} style={ user.reason === '' ? {color:'red'} : {color:'blue'}}>
                        {
                          user.reason === '' ?
                          '사유입력 필요' : '완료'
                        }
                        </tr>
                      </table>
                    </Card.Text>
                  </Card.Body>
                </Card>
              </Button>{' '}
            </div>
          </li>
        ))}
      </ul>
  );
}

export default TaxiCard;