;**********************************************************************
;   This file is a basic code template for assembly code generation   *
;   on the PIC16F877A. This file contains the basic code              *
;   building blocks to build upon.                                    *  
;                                                                     *
;   Refer to the MPASM User's Guide for additional information on     *
;   features of the assembler (Document DS33014).                     *
;                                                                     *
;   Refer to the respective PIC data sheet for additional             *
;   information on the instruction set.                               *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Filename:	    Temp_Control_Code.asm                             *
;    Date:          October 5th, 2023                                 *
;    File Version:  0                                                 *
;                                                                     *
;    Author:        SD 2023 2nd sem.                                  *
;    Company:       FIUM                                              *
;                                                                     * 
;                                                                     *
;**********************************************************************
;                                                                     *
;    Files Required: P16F877A.INC                                     *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Notes:                                                           *
;                                                                     *
;**********************************************************************


	list		p=16f877A	; list directive to define processor
	#include	<p16f877A.inc>	; processor specific variable definitions
	
	__CONFIG _CP_OFF & _WDT_OFF & _BODEN_OFF & _PWRTE_ON & _RC_OSC & _WRT_OFF & _LVP_ON & _CPD_OFF

; '__CONFIG' directive is used to embed configuration data within .asm file.
; The lables following the directive are located in the respective .inc file.
; See respective data sheet for additional information on configuration word.






;***** VARIABLE DEFINITIONS
w_temp		EQU	0x7D		; variable used for context saving 
status_temp	EQU	0x7E		; variable used for context saving
pclath_temp	EQU	0x7F		; variable used for context saving		

TempSense0	EQU d'32'		
TempSense1	EQU d'33'
Avg_Temp	EQU d'34'



;**********************************************************************
	ORG     0x000             ; processor reset vector

	nop			  ; nop required for icd
  	goto    main              ; go to beginning of program


	ORG     0x004             ; interrupt vector location

	movwf   w_temp            ; save off current W register contents
	movf	STATUS,w          ; move status register into W register
	movwf	status_temp       ; save off contents of STATUS register
	movf	PCLATH,w	  ; move pclath register into w register
	movwf	pclath_temp	  ; save off contents of PCLATH register

; isr code can go here or be located as a call subroutine elsewhere

	movf	pclath_temp,w	  ; retrieve copy of PCLATH register
	movwf	PCLATH		  ; restore pre-isr PCLATH register contents
	movf    status_temp,w     ; retrieve copy of STATUS register
	movwf	STATUS            ; restore pre-isr STATUS register contents
	swapf   w_temp,f
	swapf   w_temp,w          ; restore pre-isr W register contents
	retfie                    ; return from interrupt



main

;Configure Peripherals - begin
	;Config PORTA - begin
	bcf		STATUS, RP1
	bsf		STATUS, RP0
	movlw	b'00000000'			; set all pins as outputs
	movwf	TRISA
	movlw	0x06				; set all pins a I/O Ports
	movwf	ADCON1
	bcf		STATUS, RP1
	bcf		STATUS, RP0
	;Config PORTA - end

	;Config PORTB - begin
	bcf		STATUS, RP1
	bsf		STATUS, RP0
	movlw	b'11111111'			; set all pins as inputs
	movwf	TRISB
	bcf		STATUS, RP1
	bcf		STATUS, RP0
	movlw	0x00
	movwf	PORTB
	;Config PORTB - end

	;Config PORTC - begin
	bcf		STATUS, RP1
	bsf		STATUS, RP0
	movlw	b'11111111'			; set all pins as inputs
	movwf	TRISC
	bcf		STATUS, RP1
	bcf		STATUS, RP0
	movlw	0x00
	movwf	PORTC
	;Config PORTC - end
;Configure Peripherals - end

;Init variables - begin
	;Not used
;Init variables - end

;Config. Interrupts - begin
	bcf		INTCON, GIE			;Disable interrupts		
;Config. Interrupts - end

main_loop
; Reading - begin
	movf	PORTC,		w
	movwf	TEMP_0
	movf	PORTB,		w
	movwf	TEMP_1
; Reading - end

; Calc Avg - begin
	movf	TEMP_0,		w
	movwf	TEMP_AVG
	movf	TEMP_1,		w
	addwf	TEMP_AVG,	f
	bcf		STATUS,		0
	rrf		TEMP_AVG,	f
; Calc Avg - end

; Compare Target - begin
	movlw	d'37'
	subwf	TEMP_AVG,	f
	btfsc	STATUS,		0
	goto	heater_on
	goto	heater_off
; Compare Target - end	

; Heater on - begin
heater_on
	
; Heater on - end

; Heater off - begin
heater_off
; Heater off - end

	END                       ; directive 'end of program'