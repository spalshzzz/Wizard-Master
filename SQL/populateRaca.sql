insert into Raca (nomeRaca, caminhoImagem, descricao)
	values
	('Anão', 'anao.png', 'Reinos ricos de antiga grandeza, salões esculpidos nas raízes das montanhas, o eco de picaretas e martelos nas minas profundas e nas forjas ardentes, um compromisso com o clã e a tradição, e um ódio impetuoso contra goblins e orcs – essas linhas comuns unem todos os anões.'),
	('Elfo', 'elfo.png', 'Elfos são um povo mágico de graça sobrenatural, vivendo no mundo sem pertencer inteiramente à ele. Eles vivem em lugares de beleza aérea, no meio de antigas florestas ou em torres prateadas brilhando com luz feérica, onde uma música suave ecoa através do ar e fragrâncias suaves flutuam na brisa. Elfos amam a natureza e a magia, a arte e o estudo, a música e a poesia, e as coisas boas do mundo.'),
	('Halfling', 'halfling.png', 'Os confortos de um lar são os objetivos da maioria dos halflings: um lugar para viver em paz e sossego, longe de monstros saqueadores e embates de exércitos, com um fogo aceso e uma refeição generosa, e também uma bebida fina e boa conversa. Embora alguns halflings vivam seus dias em remotas comunidades agrícolas, outros formam bandos nômades que viajam constantemente, atraídos pela estrada afora e o vasto horizonte para descobrir as maravilhas de novas terras e povos. Mas mesmo esses halflings andarilhos amam a paz, a comida, uma lareira e um lar, mesmo que o lar seja em uma carruagem, empurrada ao longo de uma estrada de terra, ou uma balsa flutuando rio abaixo.'),
	('Humano', 'humano.png', 'Nos confins da maioria dos mundos, os humanos são a mais jovem das raças comuns, chegando mais tarde no cenário mundial e com uma vida curta, se comparados aos anões, elfos e dragões. Talvez seja por causa de suas vidas mais curtas que eles se esforcem para alcançar o máximo que podem nos anos que têm. Ou talvez eles sintam que têm algo a provar às raças mais antigas, e é por esta razão que eles constroem seus poderosos impérios através da conquista e do comércio. O que quer que os motive, os humanos são os inovadores, os realizadores e os pioneiros dos mundos.'),
	('Draconato', 'draconato.png', 'Descendentes de dragões, como seus nomes demonstram, os draconatos andam orgulhosamente pelo mundo que os saúda com um temor incompreensível. Moldados por deuses dracônicos ou pelos próprios dragões, draconatos originalmente nasceram de ovos de dragão como uma raça única, combinando os melhores atributos de dragões e humanos. Alguns draconatos são servos fieis de dragões verdadeiros, outros formas as fileiras de soldados em grandes guerras e ainda existem os que encontram-se à toa, sem um objetivo claro na vida.'),
	('Gnomo', 'gnomo.png', 'Um zumbido constante de atividades permeia a vizinhança onde os gnomos formam suas comunidades privadas. Barulhos estrondosos pontuam o zumbido: um tilintar de engrenagens moendo aqui, uma pequena explosão ali, um grito de surpresa ou comemoração e, principalmente, muitas gargalhadas. Gnomos regozijam a vida, apreciando cada momento de invento, exploração, investigação, criação e brincadeira.'),
	('Meio-Elfo', 'meio_elfo.png', 'Vagando entre dois mundos mas, na verdade, não pertencendo a nenhum dos dois, meio-elfos combinam o que alguns dizem ser as melhores qualidades dos seus parentes elfos e humanos: a curiosidade, inventividade e ambição humanas temperadas pelos sensos refinados, amor a natureza e gostos artísticos dos elfos. Alguns meio-elfos vivem entre os humanos, separados por suas diferenças emocionais e físicas, vendo seus amigos e amores envelhecer enquanto o tempo malmente os toca. Outros vivem entre os elfos, crescendo impacientes à medida que atingem a maturidade nos reinos élficos intermináveis, enquanto seus amigos continuam a viver como crianças. Muitos meio-elfos, incapazes de se encaixar em nenhuma dessas sociedades, escolhem uma vida solitária, vagando ou se juntando a outros desafortunados e adentrando uma vida de aventura.'),
	('Meio-Orc', 'meio_orc.png', 'Quer estejam unidos sob a liderança de um poderoso bruxo ou estejam lutando por um impasse após anos de conflito, tribos orcs e humanas as vezes formam alianças, unindo forças em uma vasta horda para o pavor das terras civilizadas próximas. Quando essas alianças são seladas através do casamento, os meio-orcs nascem. Alguns meio-orcs crescem e se tornam orgulhosos comandantes de tribos orcs, seu sangue humano concedem a eles um diferencial perante seus rivais orcs de sangue puro. Alguns arriscam sair pelo mundo para provar seu valor entre os humanos e outras raças mais civilizadas. Muitos desses se tornam aventureiros, adquirindo renome pelos seus poderosos feitos e notoriedade por seus costumes bárbaros e fúria selvagem.'),
	('Tiefling', 'tiefling.png', 'Ser recebido com olhares e cochichos, sofrer violência e insultos nas ruas, ver a desconfiança e medo em cada olhar: esse é o fardo do tiefling. E para completar tudo, os tieflings sabem que isso é graças ao pacto feito gerações atrás que infundiu a essência de Asmodeus – senhor supremo dos Nove Infernos – em sua linhagem. Sua aparência e natureza não é culpa deles, mas é o resultado de um pecado ancestral, pelo qual eles, seus filhos e os filhos de seus filhos serão eternamente responsabilizados.');

insert into Subraca(nomeSubRaca, nomeRaca, descricao, deslocamento, idadeAdulto, idadeExpectativaVida, tamanho, tendencia, forca, destreza, constituicao, sabedoria, inteligencia, carisma)
	values
	('Comum', 'Anão', null, 7.5, 50, 350, 'Médio', 'A maioria dos anões é leal, pois acreditam firmemente nos benefícios de uma sociedade bem organizada. Eles tendem para o bem, com um forte senso de honestidade e uma crença de que todos merecem compartilhar os benefícios de uma ordem social justa', 0, 0, 2, 0, 0, 0),
	('Anão da Colina', 'Anão', 'Como um anão da colina, você tem sentidos aguçados, maior intuição e notável resiliência. Os anões dourados de Faerûn, que vivem em seu poderoso reino ao sul do continente, são anões da colina, assim como os exilados Neidar e os depreciáveis Klar de Krynn, no cenário de Dragonlance.', 7.5, 50, 350, 'Médio', 'A maioria dos anões é leal, pois acreditam firmemente nos benefícios de uma sociedade bem organizada. Eles tendem para o bem, com um forte senso de honestidade e uma crença de que todos merecem compartilhar os benefícios de uma ordem social justa', 0, 0, 2, 1, 0, 0),
	('Anão da Montanha', 'Anão', 'Como um anão da montanha, você é forte e resistente, acostumados a uma vida difícil em terrenos difíceis. Você, provavelmente tem a descendência daqueles mais altos (para um anão) e tende a possuir uma coloração mais clara. Os anões do escudo do norte de Faerûn, bem como o clã governante Hylar e os clãs nobres Daewar de Dragonlance, são anões da montanha.', 7.5, 50, 350, 'Médio', 'A maioria dos anões é leal, pois acreditam firmemente nos benefícios de uma sociedade bem organizada. Eles tendem para o bem, com um forte senso de honestidade e uma crença de que todos merecem compartilhar os benefícios de uma ordem social justa', 2, 0, 2, 0, 0, 0),
	('Comum', 'Elfo', null, 9, 100, 750, 'Médio', 'Elfos amam a liberdade, a diversidade e a expressão pessoal, então eles inclinam-se forte e suavemente para aspectos do caos. Eles valorizam e protegem a liberdade dos outros como a sua própria, e são geralmente mais bondosos que o contrário. Os drow são exceção. Seu exílio no Subterrâneo fez deles perversos e perigosos. Drow são geralmente mais maus que o contrário.', 0, 2, 0, 0, 0, 0),
	('Alto Elfo', 'Elfo', 'Como alto elfo, você possui uma mente afiada e um domínio da magia básico. Em muitos dos mundos de D&D, existem dois tipos de altos elfos. Um tipo (que inclui os elfos cinzentos e elfos do vale de Greyhawk, os Silvanesti de Dragonlance, e os elfos do sol dos Reinos Esquecidos) são arrogantes e reclusos, acreditando serem superiores aos não elfos e até mesmo a outros elfos. O outro tipo (como os altos elfos de Greyhawk, os Qualinesti de Dragonlance e os elfos da lua dos Reinos Esquecidos) são mais comuns e amigáveis, e muitas vezes encontrados entre humanos e outras raças.<br /> Os elfos do sol de Faerûn (também chamado de elfos dourados ou elfos do amanhecer) têm pele bronzeada e cabelos cor de cobre, negros ou louro dourado. Seus olhos são dourados, prateados ou negros. Os elfos da lua (também chamados de elfos de prata ou elfos cinzentos) são muito mais pálidos, com pele de alabastro por vezes tingida de azul. Normalmente, eles têm cabelos de um branco prateado, negros ou azuis, diversos tons de loiro, castanho e vermelho não são incomuns. Seus olhos são azuis ou verdes com manchas douradas.', 9, 100, 750, 'Médio', 'Elfos amam a liberdade, a diversidade e a expressão pessoal, então eles inclinam-se forte e suavemente para aspectos do caos. Eles valorizam e protegem a liberdade dos outros como a sua própria, e são geralmente mais bondosos que o contrário. Os drow são exceção. Seu exílio no Subterrâneo fez deles perversos e perigosos. Drow são geralmente mais maus que o contrário.', 0, 2, 0, 0, 1, 0),
	('Elfo da Floresta', 'Elfo', 'Como um elfo da floresta, você possui sentidos e intuição aguçados, seus pés ágeis guiam-no rápida e furtivamente através de suas florestas nativas. Essa categoria inclui os elfos selvagens (grugach) de Greyhawk e os Kagonesti de Dragonlance, bem como as raças chamadas de elfos da floresta em Greyhawk e nos Reinos Esquecidos. Em Faerûn, os elfos da floresta (também chamados de elfos selvagens, elfos verdes ou elfos do bosque) são reclusos e desconfiados dos não elfos.<br /> A pele dos elfos da floresta tende a ser de matiz cobreada, algumas vezes com traços esverdeados. Seu cabelo geralmente é castanho ou negro, mas ocasionalmente podem ser loiros ou cor de cobre. Seus olhos são verdes, castanhos ou cor de avelã.', 10.5, 100, 750, 'Médio', 'Elfos amam a liberdade, a diversidade e a expressão pessoal, então eles inclinam-se forte e suavemente para aspectos do caos. Eles valorizam e protegem a liberdade dos outros como a sua própria, e são geralmente mais bondosos que o contrário. Os drow são exceção. Seu exílio no Subterrâneo fez deles perversos e perigosos. Drow são geralmente mais maus que o contrário.', 0, 2, 0, 1, 0, 0),
	('Elfo Negro', 'Elfo', 'Descendentes de uma antiga sub-raça de elfos de pele negra, os drow foram banidos da superfície do mundo por seguirem a deusa Lolth pelo caminho do mal e corrupção. Agora, eles construíram sua própria civilização nas profundezas do Subterrâneo, moldados pelo Caminho de Lolth. Também conhecidos como elfos negros, os drow possuem pele negra similar a obsidiana polida e cabelos brancos opacos ou amarelo pálido. Normalmente eles possuem olhos muito pálidos (tão pálidos que são confundidos com olhos brancos) com tons de lilás, prata, rosa, vermelho e azul. Eles costumam ser menores e mais magros que a maioria dos elfos.<br /> Aventureiros drow são raros e a raça não existe em todo o mundo. Verifique com seu Mestre se a raça drow está disponível como personagem de jogador.', 9, 100, 750, 'Médio', 'Elfos amam a liberdade, a diversidade e a expressão pessoal, então eles inclinam-se forte e suavemente para aspectos do caos. Eles valorizam e protegem a liberdade dos outros como a sua própria, e são geralmente mais bondosos que o contrário. Os drow são exceção. Seu exílio no Subterrâneo fez deles perversos e perigosos. Drow são geralmente mais maus que o contrário.', 0, 2, 0, 0, 0, 1),
	('Comum', 'Halfling', null, 7.5, 20, 150, 'Pequeno', 'A maioria dos halflings é leal e boa. Via de regra, eles possuem um bom coração e são amáveis, odeiam ver o sofrimento dos outros e não toleram a opressão. Eles também são muito ordeiros e tradicionais, fortemente apegados à sua comunidade e ao conforto de suas antigas tradições.', 0, 2, 0, 0, 0, 0),
	('Pés Leves', 'Halfling', 'Como um halfling pés-leves, você pode esconder-se facilmente, mesmo usando apenas outras pessoas como cobertura. Você geralmente é afável e se dá muito bem com os outros. Nos Reinos Esquecidos, os halflings pés-leves espalharam-se até os lugares mais distantes e são a variedade mais comum.<br /> Pés-leves são mais propensos à vontade de viajar do que os outros halflings, e muitas vezes vivem ao lado de outras raças ou levam uma vida nômade. No mundo de Greyhawk, estes halflings são chamados pés-peludos ou companheiros altos.', 7.5, 20, 150, 'Pequeno', 'A maioria dos halflings é leal e boa. Via de regra, eles possuem um bom coração e são amáveis, odeiam ver o sofrimento dos outros e não toleram a opressão. Eles também são muito ordeiros e tradicionais, fortemente apegados à sua comunidade e ao conforto de suas antigas tradições.', 0, 2, 0, 0, 0, 1),
	('Robusto', 'Halfling', 'Um halfling robustos é mais resistente do que a média de sua raça e possui certa resistência aos venenos. Alguns dizem que os robustos têm sangue dos anões. Nos Reinos Esquecidos, esses halflings são chamados de austeros, e são mais comuns no sul.', 7.5, 20, 150, 'Pequeno', 'A maioria dos halflings é leal e boa. Via de regra, eles possuem um bom coração e são amáveis, odeiam ver o sofrimento dos outros e não toleram a opressão. Eles também são muito ordeiros e tradicionais, fortemente apegados à sua comunidade e ao conforto de suas antigas tradições.', 0, 2, 1, 0, 0, 0),
	('Comum', 'Humano', null, 9, 20, 70, 'Médio', 'Os humanos não possuem inclinação a nenhuma tendência em especial. Os melhores e os piores são encontrados entre eles.', 1, 1, 1, 1, 1, 1),
	('Comum', 'Draconato', 'Descendentes de dragões, como seus nomes demonstram, os draconatos andam orgulhosamente pelo mundo que os saúda com um temor incompreensível. Moldados por deuses dracônicos ou pelos próprios dragões, draconatos originalmente nasceram de ovos de dragão como uma raça única, combinando os melhores atributos de dragões e humanos. Alguns draconatos são servos fieis de dragões verdadeiros, outros formas as fileiras de soldados em grandes guerras e ainda existem os que encontram-se à toa, sem um objetivo claro na vida.', 9, 15, 80, 'Média', 'Os draconatos tendem aos extremos, realizando uma escolha consciente de um lado ou do outro da guerra cósmica entre o bem e o mal (representada por Bahamut e Tiamat, espectivamente). A maioria dos draconatos é boa, mas os que vão para o lado de Tiamat podem se tornar vilões terríveis.', 2, 0, 0, 0, 0, 1),
	('Comum', 'Gnomo', null, 7.5, 40, 500, 'Pequeno', 'Os gnomos geralmente são bons. Os que tendem para a ordem são sábios, engenheiros, pesquisadores, escolásticos, investigadores ou inventores. Os que tendem ao caos são menestréis, engenhoqueiros, andarilhos ou joalheiros caprichosos. Gnomos são bons de coração e, até mesmo os trapaceiros entre eles tendem a ser mais brincalhões que perversos.', 0, 0, 0, 0, 2, 0),
	('Gnomo da Floresta', 'Gnomo', 'Como um gnomo da floresta, você possui um traquejo natural com ilusões e velocidade e furtividade naturais. Nos mundos de D&D, gnomos da floresta são raros e reservados. Eles vivem em comunidades escondidas em florestas silvestres, usando suas ilusões e truques para se esconderem das ameaças ou para mascarar sua fuga antes de serem detectados. Gnomos da floresta tendem a ser amigáveis com outros povos da floresta espirituosos e eles tem nos elfos e fadas bondosas como seus mais importantes aliados. Eles gnomos também fazem amizade com pequenos animais silvestres e contam com eles para obter informações sobre ameaças que estejam perambulando por suas terras.', 7.5, 40, 500, 'Pequeno', 'Os gnomos geralmente são bons. Os que tendem para a ordem são sábios, engenheiros, pesquisadores, escolásticos, investigadores ou inventores. Os que tendem ao caos são menestréis, engenhoqueiros, andarilhos ou joalheiros caprichosos. Gnomos são bons de coração e, até mesmo os trapaceiros entre eles tendem a ser mais brincalhões que perversos.', 0, 1, 0, 0, 2, 0),
	('Gnomo das Rochas', 'Gnomo', 'Como um gnomo das rochas, você possui uma inventividade e resistência naturais acima dos outros gnomos. A maioria dos gnomos nos mundos de D&D são gnomos das rochas, incluindo os gnomos engenhoqueiros do cenário de Dragonlance.', 7.5, 40, 500, 'Pequeno', 'Os gnomos geralmente são bons. Os que tendem para a ordem são sábios, engenheiros, pesquisadores, escolásticos, investigadores ou inventores. Os que tendem ao caos são menestréis, engenhoqueiros, andarilhos ou joalheiros caprichosos. Gnomos são bons de coração e, até mesmo os trapaceiros entre eles tendem a ser mais brincalhões que perversos.', 0, 0, 1, 0, 2, 0),
	('Comum', 'Meio-Elfo', null, 9, 20, 180, 'Médio', 'Meio-elfos compartilham a veia caótica da sua herança élfica. Eles valorizam tanto a sua liberdade quanto sua expressão criativa, não demonstrando qualquer apresso por líderes ou seguidores. Eles se irritam com regras, ressentindo com exigências de outros e, as vezes, se provam incertos, ou pelo menos, imprevisíveis.', 0, 0, 0, 0, 0, 2),
	('Comum', 'Meio-Orc', null, 9, 14, 75, 'Médio', 'Meio-orcs tem uma tendência inata ao caos devido aos seus parentes orcs e não são fortemente inclinados ao bem. Meio-orcs que cresceram entre orcs e desejam viver e estão dispostos a passar sua vida entre eles, tendem a ser malignos.', 2, 0, 1, 0, 0, 0),
	('Comum', 'Tiefling', null, 9, 20, 80, 'Médio', 'Tieflings não possuem uma tendência inata ao mal, mas muitos acabam por abraçá-lo. Maligno ou não, uma natureza independente inclina a maioria dos tieflings ao alinhamento caótico.', 0, 0, 0, 0, 1, 2);