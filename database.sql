--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-27 15:16:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16700)
-- Name: CartesLumiere; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CartesLumiere" (
    id integer NOT NULL,
    nom text NOT NULL,
    image bytea
);


ALTER TABLE public."CartesLumiere" OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16724)
-- Name: CartesPersonnage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CartesPersonnage" (
    id integer NOT NULL,
    nom text NOT NULL,
    image bytea
);


ALTER TABLE public."CartesPersonnage" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16708)
-- Name: CartesTenebre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CartesTenebre" (
    id integer NOT NULL,
    nom text NOT NULL,
    image bytea
);


ALTER TABLE public."CartesTenebre" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16716)
-- Name: CartesVision; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CartesVision" (
    id integer NOT NULL,
    nom text NOT NULL,
    image bytea
);


ALTER TABLE public."CartesVision" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16732)
-- Name: CartesAll; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."CartesAll" AS
 SELECT "CartesLumiere".id,
    "CartesLumiere".nom,
    "CartesLumiere".image
   FROM public."CartesLumiere"
UNION
 SELECT "CartesTenebre".id,
    "CartesTenebre".nom,
    "CartesTenebre".image
   FROM public."CartesTenebre"
UNION
 SELECT "CartesVision".id,
    "CartesVision".nom,
    "CartesVision".image
   FROM public."CartesVision"
UNION
 SELECT "CartesPersonnage".id,
    "CartesPersonnage".nom,
    "CartesPersonnage".image
   FROM public."CartesPersonnage"
  ORDER BY 1;


ALTER TABLE public."CartesAll" OWNER TO postgres;

--
-- TOC entry 2840 (class 0 OID 16700)
-- Dependencies: 202
-- Data for Name: CartesLumiere; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CartesLumiere" (id, nom, image) FROM stdin;
1	Amulette	\\x573a5c7368495c6c756d696572655c616d756c657474652e706e67
2	Ange Gardien	\\x573a5c7368495c6c756d696572655c616e67652d6761726469656e2e706e67
3	Avenment Suprême	\\x573a5c7368495c6c756d696572655c6176656e6d656e742d73757072656d652e706e67
4	Barre de Chocolat	\\x573a5c7368495c6c756d696572655c62617272652d64652d63686f636f6c61742e706e67
5	Bénédiction	\\x573a5c7368495c6c756d696572655c62656e6564696374696f6e2e706e67
6	Boussole Mystique	\\x573a5c7368495c6c756d696572655c626f7573736f6c652d6d797374697175652e706e67
7	Broche De Chance	\\x573a5c7368495c6c756d696572655c62726f6368652d64652d6368616e63652e706e67
8	Crucifix En Argent	\\x573a5c7368495c6c756d696572655c63727563696669782d656e2d617267656e742e706e67
9	Eau Bénite	\\x573a5c7368495c6c756d696572655c6561752d62656e6974652e706e67
10	Eau Bénite	\\x573a5c7368495c6c756d696572655c6561752d62656e6974652e706e67
11	Eclair Purificateur	\\x573a5c7368495c6c756d696572655c65636c6169722d7075726966696361746575722e706e67
12	Lance De Longinus	\\x573a5c7368495c6c756d696572655c6c616e63652d64652d6c6f6e67696e75732e706e67
13	Mirroir Divin	\\x573a5c7368495c6c756d696572655c6d6972726f69722d646976696e2e706e67
14	Premier Secours	\\x573a5c7368495c6c756d696572655c7072656d6965722d7365636f7572732e706e67
15	Savoir Ancestral	\\x573a5c7368495c6c756d696572655c7361766f69722d616e6365737472616c2e706e67
16	Toge Sainte	\\x573a5c7368495c6c756d696572655c746f67652d7361696e74652e706e67
\.


--
-- TOC entry 2843 (class 0 OID 16724)
-- Dependencies: 205
-- Data for Name: CartesPersonnage; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CartesPersonnage" (id, nom, image) FROM stdin;
48	Alie	\\x573a5c7368495c706572736f5c616c69652e706e67
49	Bob	\\x573a5c7368495c706572736f5c626f622e706e67
50	Charles	\\x573a5c7368495c706572736f5c636861726c65732e706e67
51	Daniel	\\x573a5c7368495c706572736f5c64616e69656c2e706e67
52	Emi	\\x573a5c7368495c706572736f5c656d692e706e67
53	Franklin	\\x573a5c7368495c706572736f5c6672616e6b6c696e2e706e67
54	Georges	\\x573a5c7368495c706572736f5c67656f726765732e706e67
55	Loup-Garou	\\x573a5c7368495c706572736f5c6c6f75702d6761726f752e706e67
56	Metamorphe	\\x573a5c7368495c706572736f5c6d6574616d6f727068652e706e67
57	Vampire	\\x573a5c7368495c706572736f5c76616d706972652e706e67
\.


--
-- TOC entry 2841 (class 0 OID 16708)
-- Dependencies: 203
-- Data for Name: CartesTenebre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CartesTenebre" (id, nom, image) FROM stdin;
17	Araignée Sanguinaire	\\x573a5c7368495c74656e656272655c61726169676e65652d73616e6775696e616972652e706e67
18	Chauve Souris Vampire	\\x573a5c7368495c74656e656272655c6368617576652d736f757269732d76616d706972652e706e67
19	Chauve Souris Vampire	\\x573a5c7368495c74656e656272655c6368617576652d736f757269732d76616d706972652e706e67
20	Chauve Souris Vampire	\\x573a5c7368495c74656e656272655c6368617576652d736f757269732d76616d706972652e706e67
21	Dynamite	\\x573a5c7368495c74656e656272655c64796e616d6974652e706e67
22	Hache Tueuse	\\x573a5c7368495c74656e656272655c68616368652d7475657573652e706e67
23	Hachoir Maudit	\\x573a5c7368495c74656e656272655c686163686f69722d6d61756469742e706e67
24	Mitrailleuse Funueste	\\x573a5c7368495c74656e656272655c6d69747261696c6c657573652d66756e75657374652e706e67
25	Peau De Banane	\\x573a5c7368495c74656e656272655c706561752d64652d62616e616e652e706e67
26	Poupée Démoniaque	\\x573a5c7368495c74656e656272655c706f757065652d64656d6f6e69617175652e706e67
27	Revolver Des Ténèbres	\\x573a5c7368495c74656e656272655c7265766f6c7665722d6465732d74656e65627265732e706e67
28	Rituel Diabolique	\\x573a5c7368495c74656e656272655c72697475656c2d646961626f6c697175652e706e67
29	Sabre Hanté Masamune	\\x573a5c7368495c74656e656272655c73616272652d68616e74652d6d6173616d756e652e706e67
30	Succube Tentatrice	\\x573a5c7368495c74656e656272655c737563637562652d74656e746174726963652e706e67
31	Succube Tentatrice	\\x573a5c7368495c74656e656272655c737563637562652d74656e746174726963652e706e67
32	Tronconneuse Du Mal	\\x573a5c7368495c74656e656272655c74726f6e636f6e6e657573652d64752d6d616c2e706e67
\.


--
-- TOC entry 2842 (class 0 OID 16716)
-- Dependencies: 204
-- Data for Name: CartesVision; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."CartesVision" (id, nom, image) FROM stdin;
33	Vision Clairevoyante	\\x573a5c7368495c766973696f6e5c766973696f6e2d636c61697265766f79616e74652e706e67
34	Vision Cupide	\\x573a5c7368495c766973696f6e5c766973696f6e2d6375706964652e706e67
35	Vision Cupide	\\x573a5c7368495c766973696f6e5c766973696f6e2d6375706964652e706e67
36	Vision Destructrice	\\x573a5c7368495c766973696f6e5c766973696f6e2d6465737472756374726963652e706e67
37	Vision Divine	\\x573a5c7368495c766973696f6e5c766973696f6e2d646976696e652e706e67
38	Vision Enivrante	\\x573a5c7368495c766973696f6e5c766973696f6e2d656e697672616e74652e706e67
39	Vision Enivrante	\\x573a5c7368495c766973696f6e5c766973696f6e2d656e697672616e74652e706e67
40	Vision Foudroyante	\\x573a5c7368495c766973696f6e5c766973696f6e2d666f7564726f79616e74652e706e67
41	Vision-Furtive	\\x573a5c7368495c766973696f6e5c766973696f6e2d667572746976652e706e67
42	Vision-Furtive	\\x573a5c7368495c766973696f6e5c766973696f6e2d667572746976652e706e67
43	Vision Lugubre	\\x573a5c7368495c766973696f6e5c766973696f6e2d6c7567756272652e706e67
44	Vision Mortifière	\\x573a5c7368495c766973696f6e5c766973696f6e2d6d6f72746966696572652e706e67
45	Vision Purificatrice	\\x573a5c7368495c766973696f6e5c766973696f6e2d707572696669636174726963652e706e67
46	Vision Réconfortante	\\x573a5c7368495c766973696f6e5c766973696f6e2d7265636f6e666f7274616e74652e706e67
47	Vision Suprême	\\x573a5c7368495c766973696f6e5c766973696f6e2d73757072656d652e706e67
\.


--
-- TOC entry 2706 (class 2606 OID 16707)
-- Name: CartesLumiere CartesLumiere_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CartesLumiere"
    ADD CONSTRAINT "CartesLumiere_pkey" PRIMARY KEY (id);


--
-- TOC entry 2712 (class 2606 OID 16731)
-- Name: CartesPersonnage CartesPersonnage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CartesPersonnage"
    ADD CONSTRAINT "CartesPersonnage_pkey" PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 16715)
-- Name: CartesTenebre CartesTenebre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CartesTenebre"
    ADD CONSTRAINT "CartesTenebre_pkey" PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 16723)
-- Name: CartesVision CartesVision_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CartesVision"
    ADD CONSTRAINT "CartesVision_pkey" PRIMARY KEY (id);


-- Completed on 2020-04-27 15:16:35

--
-- PostgreSQL database dump complete
--

