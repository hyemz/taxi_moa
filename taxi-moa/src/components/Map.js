import React, { useEffect } from 'react';
import KakaoMapScript from './KakaoMapScript';
import { Card } from 'react-bootstrap';

export default function Map() {
  useEffect(() => {
    KakaoMapScript();
  }, []);

  return (
    <Card>
      <div
        style={{
          width: '100%',
          display: 'inline-block',
          marginLeft: '5px',
          marginRight: '5px',
        }}
      >
        <div id="map" style={{ width: '99%', height: '500px' }}></div>
      </div>
    </Card>
  );
}
