import { Dimensions } from 'react-native';
export const infoBarHeight = 28;
export const headerHeight = 60;
export const windowWidth = Dimensions.get('window').width;
export const windowHeight = Dimensions.get('window').height - (infoBarHeight + headerHeight);
const IP = '192.168.3.101';
export const baseUrl = 'http://' + IP + ':8080/';