module.exports = {
  purge: ['./src/**/*.{js,jsx,ts,tsx}', './public/index.html'],
  darkMode: false, // or 'media' or 'class'
  theme: {
    fontFamily : {
      'body': ['"PT Sans"'],
      'display': ['"Merryweather Sans"'],
    }
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
