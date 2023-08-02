import React, { useState, useEffect } from 'react';
import { windowWidth, windowHeight } from '../../constants';
import axios from 'axios';
import { baseUrl } from '../../constants';
import NewQuestionModal from './newQuestionModal';

import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Button,
  useColorScheme,
  View,
  Text,
  TouchableHighlight,
} from 'react-native';


function AnimeScreen({ navigation }: any): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  const [questions, setQuestions] = useState([]);
  const [errorMassage, setErrorMassage] = useState(null);
  const [filterValues, setFilterValues] = useState({ 'title': '', 'description': '' });
  const [modalVisible, setModalVisible] = useState(false);

  const getData = async () => {
    console.log('AnimeScreen getData', 'OK');
    await axios.get(baseUrl + 'questions', {}
    ).then((response) => {
console.log('AnimeScreen response', response);

      setQuestions(response.data.content);
    }).catch(function (error) {
      console.log('error', error.message);
      setErrorMassage(error.message);
    });
  }

  useEffect(() => {
    getData();
  }, []);

  /** Фильтры create/update */
  //  const changeItemValue = (accessor: any, value: any) => {
  //   let newItems = {...filterValues};
  //   newItems[accessor] = value;
  //   setFilterValues(newItems);
  // };

  return (
    <SafeAreaView>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={'white'}
      />
      <View style={styles.mainPage}>
        <Text style={styles.questionsTitle}>{'Questions'}</Text>
        <ScrollView contentInsetAdjustmentBehavior="automatic" style={styles.questions}>
          {questions.map((question, idx) =>
            <View style={styles.question} key={idx}>
              <Text style={styles.questionTitle}>{question.title}</Text>
              <Text style={styles.questionDescription}>{question.description}</Text>
            </View>
          )}
        </ScrollView>
        <TouchableHighlight
          style={[styles.btn, styles.btnOpen]}
          activeOpacity={0.6}
          underlayColor={'rgba(252,238,10,.15)'}
          onPress={() => setModalVisible(true)}>
          <Text style={styles.btnTextStyle}>{'new Question'}</Text>
        </TouchableHighlight>
        <NewQuestionModal
          modalVisible={modalVisible}
          setModalVisible={setModalVisible}
          questions={questions}
          setQuestions={setQuestions} />
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  mainPage: {
    // width: windowWidth,
    height: windowHeight,
    display: 'flex',
    flexDirection: 'column',
    // justifyContent: 'space-between',
    // alignItems: 'center',
    backgroundColor: 'rgba(0,0,0, 0.9)',
    padding: 15,
  },
  questions: {
    marginBottom: 10,
    borderLeftWidth: 2,
    borderLeftColor: 'yellow',
    borderRightWidth: 2,
    borderRightColor: 'yellow',
  },
  question: {
    backgroundColor: 'rgba(0,0,0, 0.9)',
    display: 'flex',
    flexDirection: 'row',
    padding: 10,

    marginBottom: 8,
  },
  questionsTitle: {
    fontSize: 18,
    letterSpacing: 1,
    textAlign: 'center',
    marginTop: 5,
    color: '#00F0FF',
    paddingBottom: 15,
  },
  questionTitle: {
    color: '#fcee0a',
    marginRight: 10,
  },
  questionDescription: {
    color: '#FFFFFF',
  },
  btn: {
    borderRadius: 4,
    padding: 10,
    elevation: 2,
    borderWidth: 2,
    borderColor: '#00F0FF',
    marginBottom: 8,
  },
  btnOpen: {
    // backgroundColor: 'rgba(252,238,10,.15)',
  },
  btnTextStyle: {
    fontStyle: 'italic',
    color: '#e53f2a',
    fontWeight: 'bold',
    textAlign: 'center',
    fontSize: 14,
  },
});

export default AnimeScreen;
