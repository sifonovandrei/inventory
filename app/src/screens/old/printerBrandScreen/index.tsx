import React, { useState, useEffect } from 'react';
import { windowWidth, windowHeight } from '../../../constants';
import axios from 'axios';
import { baseUrl } from '../../../constants';
import AddItemModal from './AddItemModal';

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


function PrinterBrandScreen({ navigation }: any): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  const [questions, setPrinterBrand] = useState([]);
  const [errorMassage, setErrorMassage] = useState(null);
  const [filterValues, setFilterValues] = useState({ 'title': '', 'description': '' });
  const [modalVisible, setModalVisible] = useState(false);

  const getData = async () => {
    await axios.get(baseUrl + 'questions', {}
    ).then((response) => {

      setPrinterBrand(response.data.content);
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
        <Text style={styles.questionsTitle}>{'Printer Brands'}</Text>
        <ScrollView contentInsetAdjustmentBehavior="automatic" style={styles.printerBrands}>
          {questions.map((question, idx) =>
            <View style={styles.question} key={idx}>
              <Text style={styles.questionTitle}>{question.brand}</Text>
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
        <AddItemModal
          modalVisible={modalVisible}
          setModalVisible={setModalVisible}
          items={questions}
          setItems={setPrinterBrand}
          api={'printerBrand'} />
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
  PrinterBrands: {
    marginBottom: 10,
    borderLeftWidth: 2,
    borderLeftColor: 'yellow',
    borderRightWidth: 2,
    borderRightColor: 'yellow',
  },
  PrinterBrand: {
    backgroundColor: 'rgba(0,0,0, 0.9)',
    display: 'flex',
    flexDirection: 'row',
    padding: 10,

    marginBottom: 8,
  },
  PrinterBrandsTitle: {
    fontSize: 18,
    letterSpacing: 1,
    textAlign: 'center',
    marginTop: 5,
    color: '#00F0FF',
    paddingBottom: 15,
  },
  PrinterBrandBrand: {
    color: '#fcee0a',
    marginRight: 10,
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

export default PrinterBrandScreen;
